package TRaMis8khae.starbucks.common.utils;

import TRaMis8khae.starbucks.media.entity.Media;
import TRaMis8khae.starbucks.media.entity.MediaKind;
import TRaMis8khae.starbucks.media.entity.MediaType;
import TRaMis8khae.starbucks.product.entity.Product;
import TRaMis8khae.starbucks.review.dto.ReviewCrawlingAddDto;
import TRaMis8khae.starbucks.review.entity.Review;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Slf4j
@Profile("crawling")  // "crawling" 프로파일이 활성화되었을 때만 이 설정이 적용됨
@Component
public class CrawlingInit {

    @PostConstruct
    public void parseAndSaveData() throws IOException {

        log.info("start!!!!!");

        // 엑셀 파일 경로 (예시로 로컬 파일 경로 사용)
        String excelFilePath = "C:\\Users\\baek\\Desktop\\starbucks_products.xlsx";

        // 엑셀 데이터 파싱 및 DB 저장
        try {
            parseExcelData(excelFilePath);
        } catch (IOException e) {
            log.error("파일 읽기 오류 : {}", e.getMessage());
        }
    }

    // 엑셀 데이터를 파싱하고 DB에 저장하는 메서드
    public void parseExcelData(String excelFilePath) throws IOException {
        FileInputStream file = new FileInputStream(excelFilePath);
        Workbook workbook = new XSSFWorkbook(file);

        // 엑셀 파일의 모든 시트를 순회하며 데이터 파싱
        for (Sheet sheet : workbook) {
            log.info("Sheet name : {}", sheet.getSheetName());

            // todo sheet 이름별로 topCode 생성
            String categoryName = sheet.getSheetName();


            for (Row row : sheet) {

                if(row.getRowNum() == 0) {
                    continue;
                }

                // media
                String thumbNailMedia = getCellValue(row.getCell(0));
                String mainMedia = getCellValue(row.getCell(6));
//                log.info("thumbNailMedia : {}", thumbNailMedia);
//                log.info("mainMedia : {}", mainMedia);

                // product
                String productName = getCellValue(row.getCell(1));
                String productUUID = getCellValue(row.getCell(3));
                String price = getCellValue(row.getCell(2));
                String descriptionImage = getCellValue(row.getCell(7));
                String descriptionTag = getCellValue(row.getCell(8));
//                log.info("productName : {}", productName);
//                log.info("productUUID : {}", productUUID);
//                log.info("price : {}", price);
//                log.info("descriptionImage : {}", descriptionImage);
//                log.info("descriptionTag : {}", descriptionTag);

                // event
                String discountRate = getCellValue(row.getCell(4));
//                log.info("discountRate : {}", discountRate);

                // review
                String readReview = getCellValue(row.getCell(9));
//                log.info("review : {}", review);

                // media 객체 생성
                List<Media> mediaList = parseMedia(thumbNailMedia, mainMedia);
                for (Media media : mediaList) {
                    log.info("media : {}", media);
                }

                // product 객체 생성
                Product parsedProduct = parseProduct(productName, Double.parseDouble(price), descriptionImage, descriptionTag);
                log.info("product : {}", parsedProduct);

                // event 객체 생성

                // review 객체 생성
                ObjectMapper objectMapper = new ObjectMapper();

                // 리뷰 데이터를 중괄호 기준으로 나누기
                List<String> reviews = splitReviews(readReview);

                for (String reviewString : reviews) {
                    // 각 리뷰를 JSON 형식으로 파싱
                    Map<String, Object> readValue = objectMapper.readValue(reviewString, new TypeReference<Map<String, Object>>() {});

                    // review 정보를 ReviewCrawlingAddDto로 변환
                    ReviewCrawlingAddDto reviewDto = ReviewCrawlingAddDto.toDto(
                            (String) readValue.get("rating"),
                            (String) readValue.get("reviewer"),
                            (String) readValue.get("reviewContent")
                    );

                    // reviewImages를 List<String>으로 변환
                    List<String> reviewImages = (List<String>) readValue.get("reviewImages");

                    List<Media> reviewMediaList = new ArrayList<>();  // Media 리스트 생성

                    if (reviewImages != null && !reviewImages.isEmpty()) {
                        if (reviewImages.size() == 1) {
                            // 이미지가 1개일 때
                            reviewMediaList = parseMedia(reviewImages.get(0), reviewImages.get(0));  // 썸네일만 전달, mainMedia는 null
                        } else if (reviewImages.size() > 1) {
                            // 이미지가 2개 이상일 때
                            String thumbnailMedia = reviewImages.get(0);  // 첫 번째 이미지를 썸네일로
                            String reviewMedia = String.join(", ", reviewImages.subList(1, reviewImages.size()));  // 나머지를 mainMedia로
                            reviewMediaList = parseMedia(thumbnailMedia, reviewMedia);  // 썸네일과 나머지 이미지를 함께 전달
                        }
                    }

                    log.info("review : {}", reviewDto);
                    for (Media media : reviewMediaList) {
                        log.info("reviewMedia : {}", media);
                    }

                }

                // todo : 데이터 저장

            }

        }

        workbook.close();
        file.close();
    }

    private String getCellValue(Cell cell) {
        return cell == null ? "" : cell.getStringCellValue();
    }

    // Media 파싱 메서드 (위에서 작성한 것과 동일)
    public List<Media> parseMedia(String thumbnailMedia, String mainMedia) {
        List<Media> mediaList = new ArrayList<>();

        // thumbnailMedia를 Media 객체로 변환
        Media thumbMedia = Media.builder()
                .mediaUrl(thumbnailMedia)
                .thumbChecked(true)
                .mediaType(MediaType.IMAGE)
                .mediaKind(MediaKind.PRODUCT)
                .mediaSeq(1) // 썸네일의 seq는 1로 설정
                .build();

        mediaList.add(thumbMedia);

        // mainMedia를 쉼표 기준으로 분리하여 각각 Media 객체로 변환
        List<String> mediaUrls = Arrays.stream(mainMedia.split(","))
                .map(String::trim) // 각 URL에서 공백 제거
                .collect(Collectors.toList());

        // 나머지 이미지들은 thumbChecked = false로 설정하여 Media 객체로 추가
        for (int i = 0; i < mediaUrls.size(); i++) {
            Media detailMedia = Media.builder()
                    .mediaUrl(mediaUrls.get(i))
                    .thumbChecked(false)
                    .mediaType(MediaType.IMAGE)
                    .mediaKind(MediaKind.PRODUCT)
                    .mediaSeq(i + 2) // seq는 2부터 시작
                    .build();

            mediaList.add(detailMedia);
        }

        return mediaList;
    }

    // Product 파싱 메서드 (위에서 작성한 것과 동일)

    public Product parseProduct(String productName, Double price, String descriptionImage,
                                String descriptionTag) {
        return Product.builder()
                .productName(productName)
                .price(price)
                .description(descriptionImage)
//                .description(descriptionTag)
                .build();
    }

    public List<String> splitReviews(String reviewData) {
        // 중괄호를 기준으로 각 리뷰를 나눔
        List<String> reviews = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\{[^}]*\\}").matcher(reviewData);

        while (matcher.find()) {
            reviews.add(matcher.group());
        }
        return reviews;

    private Double parsePrice(String price) {
        try {
            return Double.parseDouble(price.replace("원", "").replace(",", ""));
        } catch (NumberFormatException e) {
            log.error("Invalid price format: {}", price);
            return 0.0; // 기본값 설정
        }

    }

    // DB 저장 메서드 (예시로 정의)
    private void saveProduct(Product product) {
        // productRepository.save(product); (repository나 service 호출)
    }

    private void saveMedia(List<Media> mediaList) {
        // mediaRepository.saveAll(mediaList); (repository나 service 호출)
    }
}
