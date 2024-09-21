package TRaMis8khae.starbucks.common.utils;

import TRaMis8khae.starbucks.media.entity.Media;
import TRaMis8khae.starbucks.media.entity.MediaKind;
import TRaMis8khae.starbucks.media.entity.MediaType;
import TRaMis8khae.starbucks.product.entity.Product;
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
import java.util.List;

@Slf4j
@Profile("crawling")  // "crawling" 프로파일이 활성화되었을 때만 이 설정이 적용됨
@Component
public class CrawlingInit {

    @PostConstruct
    public void parseAndSaveData() throws IOException {

        log.info("start!!!!!");

        // 엑셀 파일 경로 (예시로 로컬 파일 경로 사용)
        String excelFilePath = "D:\\starbucks_products2.xlsx";

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
        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            // 각 셀의 데이터 가져오기
//            String productName = row.getCell(2).getStringCellValue();
//            String price = row.getCell(3).getStringCellValue();
//            String descriptionImage = row.getCell(6).getStringCellValue();
//            String thumbnail = row.getCell(1).getStringCellValue();
//            String detailThumbnail = row.getCell(5).getStringCellValue();

            String productName = getCellValue(row.getCell(2));
            String price = getCellValue(row.getCell(3));
            String descriptionImage = getCellValue(row.getCell(6));
            String thumbnail = getCellValue(row.getCell(1));
            String detailThumbnail = getCellValue(row.getCell(5));


            log.info("productName : {}", productName);
            log.info("price : {}", price);
            log.info("descriptionImage : {}", descriptionImage);
            log.info("thumbnail : {}", thumbnail);
            log.info("detailThumbnail : {}", detailThumbnail);

            // Media 객체 생성
            List<Media> mediaList = parseMedia(thumbnail, detailThumbnail);
            for (Media media : mediaList) {
                log.info("media : {}", media);
            }

            // Product 객체 생성
            Product product = parseProduct(productName, price, descriptionImage);
            log.info("product : {}", product);

            // 데이터 저장 (saveProduct, saveMedia는 각각의 repository 또는 service를 통해 DB에 저장)
            saveProduct(product);
            saveMedia(mediaList);
        }

        workbook.close();
        file.close();
    }

    private String getCellValue(Cell cell) {
        return cell == null ? "" : cell.getStringCellValue();
    }


    // Media 파싱 메서드 (위에서 작성한 것과 동일)
    public List<Media> parseMedia(String thumbnailUrl, String detailThumbnailUrl) {
        List<Media> mediaList = new ArrayList<>();

        Media thumbMedia = Media.builder()
                .mediaUrl(thumbnailUrl)
                .thumbChecked(true)
                .mediaType(MediaType.IMAGE)
                .mediaKind(MediaKind.PRODUCT)
                .mediaSeq(1)
                .build();

        Media detailMedia = Media.builder()
                .mediaUrl(detailThumbnailUrl)
                .thumbChecked(false)
                .mediaType(MediaType.IMAGE)
                .mediaKind(MediaKind.PRODUCT)
                .mediaSeq(2)
                .build();

        mediaList.add(thumbMedia);
        mediaList.add(detailMedia);

        return mediaList;
    }

    // Product 파싱 메서드 (위에서 작성한 것과 동일)
    public Product parseProduct(String productName, String price, String description) {
        Double priceValue = parsePrice(price);

        return Product.builder()
                .productName(productName)
                .price(priceValue)
                .description(description)
                .build();
    }

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
