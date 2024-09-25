package TRaMis8khae.starbucks.common.utils;

import TRaMis8khae.starbucks.admin.dto.in.TopCategoryRequestDto;
import TRaMis8khae.starbucks.admin.entity.BottomCategory;
import TRaMis8khae.starbucks.admin.entity.MiddleCategory;
import TRaMis8khae.starbucks.admin.entity.TopCategory;
import TRaMis8khae.starbucks.admin.infrastructure.BottomCategoryRepository;
import TRaMis8khae.starbucks.admin.infrastructure.MiddleCategoryRepository;
import TRaMis8khae.starbucks.admin.infrastructure.TopCategoryRepository;
import TRaMis8khae.starbucks.admin.vo.TopCategoryRequestVo;
import TRaMis8khae.starbucks.event.entity.Event;
import TRaMis8khae.starbucks.event.entity.ProductEventList;
import TRaMis8khae.starbucks.event.infrastructure.EventRepository;
import TRaMis8khae.starbucks.media.entity.Media;
import TRaMis8khae.starbucks.media.entity.MediaKind;
import TRaMis8khae.starbucks.media.entity.MediaType;
import TRaMis8khae.starbucks.media.infrastructure.MediaRepository;
import TRaMis8khae.starbucks.product.entity.Product;
import TRaMis8khae.starbucks.product.infrastructure.ProductRepository;
import TRaMis8khae.starbucks.review.dto.ReviewCrawlingAddDto;
import TRaMis8khae.starbucks.review.entity.Review;
import TRaMis8khae.starbucks.review.infrastructure.ReviewRepository;
import TRaMis8khae.starbucks.vendor.entity.ProductCategoryList;
import TRaMis8khae.starbucks.vendor.infrastructure.ProductCategoryListRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

@Slf4j
@Profile("crawling")  // "crawling" 프로파일이 활성화되었을 때만 이 설정이 적용됨
@Component
@RequiredArgsConstructor
public class CrawlingInit {
    
    private final ReviewRepository reviewRepository;
    private final EventRepository eventRepository;
    private final ProductRepository productRepository;
    private final ProductCategoryListRepository productCategoryListRepository;
    private final MediaRepository mediaRepository;
    private final TopCategoryRepository topCategoryRepository;
    private final MiddleCategoryRepository middleCategoryRepository;
    private final BottomCategoryRepository bottomCategoryRepository;

    @PostConstruct
    public void parseAndSaveData() throws IOException {

        log.info("start!!!!!");

        // 엑셀 파일 경로 (예시로 로컬 파일 경로 사용)
        String excelFilePath = "C:\\Users\\ssginc53\\Documents\\starbucks_products.xlsx";

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
        int topCount = 0;

        Sheet tumblr = workbook.getSheetAt(0); //키친/테이블
        Sheet mug = workbook.getSheetAt(1); //키친/테이블
        Sheet bakery = workbook.getSheetAt(2); //푸드
        Sheet cake = workbook.getSheetAt(3); //푸드
        Sheet sandwich = workbook.getSheetAt(4); //푸드
        Sheet coffee = workbook.getSheetAt(5); //커피용품
        Sheet fabric = workbook.getSheetAt(6); //라이프스타일
        Sheet homeDeco = workbook.getSheetAt(7); //라이프스타일
        Sheet fancy = workbook.getSheetAt(8); //라이프스타일
        Sheet drink = workbook.getSheetAt(9); //커피/음료/e-gift
        Sheet eGift = workbook.getSheetAt(10); //커피/음료/e-gift

        TopCategory total = parseTopCategory("전체", topCount++);
        saveTopCategory(total);

        TopCategory kitchenTable = parseTopCategory("키친/테이블", topCount++);
        MiddleCategory kitchenTableMid = parseMiddleCategory(kitchenTable, 0);
        BottomCategory kitchenTableBot1 = parseBottomCategory(kitchenTableMid, tumblr.getSheetName(), 0);
        BottomCategory kitchenTableBot2 = parseBottomCategory(kitchenTableMid, mug.getSheetName(), 1);
        saveTopCategory(kitchenTable);
        saveMiddleCategory(kitchenTableMid);
        saveBottomCategory(kitchenTableBot1);
        saveBottomCategory(kitchenTableBot2);

        TopCategory food = parseTopCategory("푸드", topCount++);
        MiddleCategory foodMid = parseMiddleCategory(food, 0);
        BottomCategory foodBot1 = parseBottomCategory(foodMid, bakery.getSheetName(), 0);
        BottomCategory foodBot2 = parseBottomCategory(foodMid, cake.getSheetName(), 1);
        BottomCategory foodBot3 = parseBottomCategory(foodMid, sandwich.getSheetName(), 2);
        saveTopCategory(food);
        saveMiddleCategory(foodMid);
        saveBottomCategory(foodBot1);
        saveBottomCategory(foodBot2);
        saveBottomCategory(foodBot3);

        TopCategory coffeeTea = parseTopCategory("커피/티용품", topCount++);
        MiddleCategory coffeeTeaMid = parseMiddleCategory(coffeeTea, 0);
        BottomCategory coffeeTeaBot = parseBottomCategory(coffeeTeaMid, coffee.getSheetName(), 0);
        saveTopCategory(coffeeTea);
        saveMiddleCategory(coffeeTeaMid);
        saveBottomCategory(coffeeTeaBot);

        TopCategory lifeStyle = parseTopCategory("라이프스타일", topCount++);
        MiddleCategory lifeStyleMid = parseMiddleCategory(lifeStyle, 0);
        BottomCategory lifeStyleBot1 = parseBottomCategory(lifeStyleMid, fabric.getSheetName(), 0);
        BottomCategory lifeStyleBot2 = parseBottomCategory(lifeStyleMid, homeDeco.getSheetName(), 1);
        BottomCategory lifeStyleBot3 = parseBottomCategory(lifeStyleMid, fancy.getSheetName(), 2);
        saveTopCategory(lifeStyle);
        saveMiddleCategory(lifeStyleMid);
        saveBottomCategory(lifeStyleBot1);
        saveBottomCategory(lifeStyleBot2);
        saveBottomCategory(lifeStyleBot3);

        TopCategory coffeeBeverageGift = parseTopCategory("커피/음료/e-gift", topCount);
        MiddleCategory coffeeBeverageGiftMid = parseMiddleCategory(coffeeBeverageGift, 0);
        BottomCategory coffeeBeverageGiftBot1 = parseBottomCategory(coffeeBeverageGiftMid, drink.getSheetName(), 0);
        BottomCategory coffeeBeverageGiftBot2 = parseBottomCategory(coffeeBeverageGiftMid, eGift.getSheetName(), 1);
        saveTopCategory(coffeeBeverageGift);
        saveMiddleCategory(coffeeBeverageGiftMid);
        saveBottomCategory(coffeeBeverageGiftBot1);
        saveBottomCategory(coffeeBeverageGiftBot2);

        for (Sheet sheet : workbook) {
            log.info("Sheet name : {}", sheet.getSheetName());
            String categoryName = sheet.getSheetName();

            for (Row row : sheet) {
                if(row.getRowNum() == 0) { continue;}

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
                saveMedia(mediaList);

                // 전체
                List<ProductCategoryList> productCategoryAll = new ArrayList<>();
                productCategoryAll.add(parseProductCategory(productUUID, total.getCode(), null, null));

                log.info("categoryName : {} ", categoryName);
                switch (categoryName) {
                    case "텀블러-보온병":
                        productCategoryAll.add(parseProductCategory(productUUID, kitchenTable.getCode(), kitchenTableMid.getCode(), kitchenTableBot1.getCode()));
                        break;
                    case "컵-머그":
                        productCategoryAll.add(parseProductCategory(productUUID, kitchenTable.getCode(), kitchenTableMid.getCode(), kitchenTableBot2.getCode()));
                        break;
                    case "베이커리":
                        productCategoryAll.add(parseProductCategory(productUUID, food.getCode(), foodMid.getCode(), foodBot1.getCode()));
                        break;
                    case "디저트-케이크":
                        productCategoryAll.add(parseProductCategory(productUUID, food.getCode(), foodMid.getCode(), foodBot2.getCode()));
                        break;
                    case "샐러드-샌드위치":
                        productCategoryAll.add(parseProductCategory(productUUID, food.getCode(), foodMid.getCode(), foodBot3.getCode()));
                        break;
                    case "커피용품":
                        productCategoryAll.add(parseProductCategory(productUUID, coffeeTea.getCode(), coffeeTeaMid.getCode(), coffeeTeaBot.getCode()));
                        break;
                    case "페브릭":
                        productCategoryAll.add(parseProductCategory(productUUID, lifeStyle.getCode(), lifeStyleMid.getCode(), lifeStyleBot1.getCode()));
                        break;
                    case "홈데코":
                        productCategoryAll.add(parseProductCategory(productUUID, lifeStyle.getCode(), lifeStyleMid.getCode(), lifeStyleBot2.getCode()));
                        break;
                    case "문구-팬시":
                        productCategoryAll.add(parseProductCategory(productUUID, lifeStyle.getCode(), lifeStyleMid.getCode(), lifeStyleBot3.getCode()));
                        break;
                    case "음료-요거트":
                        productCategoryAll.add(parseProductCategory(productUUID, coffeeBeverageGift.getCode(), coffeeBeverageGiftMid.getCode(), coffeeBeverageGiftBot1.getCode()));
                        break;
                    case "e-gift":
                        productCategoryAll.add(parseProductCategory(productUUID, coffeeBeverageGift.getCode(), coffeeBeverageGiftMid.getCode(), coffeeBeverageGiftBot2.getCode()));
                        break;
                }
                saveProductCategoryList(productCategoryAll);

                // product 객체 생성
                Product parsedProduct = parseProduct(productName, Double.parseDouble(price), descriptionImage, descriptionTag);
                log.info("product : {}", parsedProduct);
                saveProduct(parsedProduct);

                // event 객체 생성
                int discountRateValue = Integer.parseInt(discountRate);

                // discountRate가 0보다 큰 경우에만 저장 처리
                if (discountRateValue > 0) {

                    Event event = Event.builder()
                            .discountRate(discountRateValue)
                            .build();

                    ProductEventList productEventList = ProductEventList.builder()
                            .product(parsedProduct)
                            .event(event)
                            .build();

                    log.info("!event : {}", event.getDiscountRate());
                    log.info("!productEventList : {}", productEventList.getEvent());
                    log.info("!productEventListProduct : {}", productEventList.getProduct());
                }

                // todo event 저장

                // 임시 : eventMedia(이미지) 추가
//                List<Media> eventMediaList = new ArrayList<>();
//                eventMediaList = parseMedia(eventImage);
//                for (Media media : eventMediaList) {
//                    log.info("eventMedia : {}", media);
//                }
//                if (eventMediaList.size() > 0) {
//                    EventRequestDto eventRequestDto = EventRequestDto.builder()
//                            .eventId(event.getId())
//                            .mediaList(eventMediaList)
//                            .build();
//                    eventRequestDtoList.add(eventRequestDto);
//                }

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
                        } else {
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

                    saveReview(reviewDto.toEntity());
                    saveMedia(reviewMediaList);
                }
            }
        }

        workbook.close();
        file.close();
    }

    private String getCellValue(Cell cell) {
        return cell == null ? "" : cell.getStringCellValue();
    }

    public List<String> splitReviews(String reviewData) {
        // 중괄호를 기준으로 각 리뷰를 나눔
        List<String> reviews = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\{[^}]*}").matcher(reviewData);

        while (matcher.find()) {
            reviews.add(matcher.group());
        }
        return reviews;
    }

    // -------------------------------- parsing methods --------------------------------
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
                .toList();

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

    public Product parseProduct(String productName, Double price, String descriptionImage,
                                String descriptionTag) {
        return Product.builder()
                .productName(productName)
                .price(price)
                .description(descriptionImage)
//                .description(descriptionTag)
                .build();
    }

    public TopCategory parseTopCategory(String categoryName, Integer sequence) {
        return TopCategory.builder()
                .name(categoryName)
                .sequence(sequence)
                .code(CodeGenerator.generateCode(8))
                .build();
    }

    public MiddleCategory parseMiddleCategory(TopCategory topCategory, Integer sequence) {
        return MiddleCategory.builder()
                .topCategory(topCategory)
                .name("카테고리")
                .sequence(sequence)
                .code(CodeGenerator.generateCode(8))
                .build();
    }

    public BottomCategory parseBottomCategory(MiddleCategory middleCategory, String name, Integer sequence) {
        return BottomCategory.builder()
                .middleCategory(middleCategory)
                .name(name)
                .sequence(sequence)
                .code(CodeGenerator.generateCode(8))
                .build();
    }

    public ProductCategoryList parseProductCategory(String uuid, String topCode, String middleCode, String bottomCode) {
        return ProductCategoryList.builder()
                .productUUID(uuid)
                .topCode(topCode)
                .middleCode(middleCode)
                .bottomCode(bottomCode)
                .build();
    }

    // -------------------------------- save methods --------------------------------
    private void saveTopCategory(TopCategory topCategory) {
        topCategoryRepository.save(topCategory);
    }


    private void saveBottomCategory(BottomCategory bottomCategory) {
        bottomCategoryRepository.save(bottomCategory);

    }

    private void saveMiddleCategory(MiddleCategory middleCategory) {
        middleCategoryRepository.save(middleCategory);

    }

    private void saveProductCategoryList(List<ProductCategoryList> productCategoryAll) {
        productCategoryListRepository.saveAll(productCategoryAll);
    }
    private void saveProduct(Product product) {
        productRepository.save(product);
    }

    private void saveMedia(List<Media> mediaList) {
        mediaRepository.saveAll(mediaList);
    }

    private void saveEvent(Event event) {
        eventRepository.save(event);
    }

    private void saveReview(Review review) {
        reviewRepository.save(review);
    }

}