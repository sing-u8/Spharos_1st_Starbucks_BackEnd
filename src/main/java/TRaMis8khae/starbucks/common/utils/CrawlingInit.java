package TRaMis8khae.starbucks.common.utils;

import TRaMis8khae.starbucks.admin.application.CategoryService;

import TRaMis8khae.starbucks.admin.application.MenuCategoryService;
import TRaMis8khae.starbucks.admin.dto.in.BottomCategoryRequestDto;
import TRaMis8khae.starbucks.admin.dto.in.MenuCategoryRequestDto;
import TRaMis8khae.starbucks.admin.dto.in.MiddleCategoryRequestDto;
import TRaMis8khae.starbucks.admin.dto.in.TopCategoryRequestDto;
import TRaMis8khae.starbucks.admin.entity.BottomCategory;
import TRaMis8khae.starbucks.admin.entity.MiddleCategory;
import TRaMis8khae.starbucks.admin.entity.TopCategory;
import TRaMis8khae.starbucks.admin.infrastructure.BottomCategoryRepository;
import TRaMis8khae.starbucks.admin.infrastructure.MiddleCategoryRepository;
import TRaMis8khae.starbucks.admin.infrastructure.TopCategoryRepository;
import TRaMis8khae.starbucks.admin.vo.BottomCategoryRequestVo;
import TRaMis8khae.starbucks.admin.vo.MenuCategoryRequestVo;
import TRaMis8khae.starbucks.admin.vo.MiddleCategoryRequestVo;
import TRaMis8khae.starbucks.admin.vo.TopCategoryRequestVo;
import TRaMis8khae.starbucks.event.application.EventService;
import TRaMis8khae.starbucks.event.dto.in.EventRequestDto;
import TRaMis8khae.starbucks.event.dto.in.ProductEventListRequestDto;
import TRaMis8khae.starbucks.event.entity.Event;
import TRaMis8khae.starbucks.event.entity.EventMedia;
import TRaMis8khae.starbucks.event.entity.ProductEventList;
import TRaMis8khae.starbucks.event.infrastructure.EventRepository;
import TRaMis8khae.starbucks.event.vo.in.EventRequestVo;
import TRaMis8khae.starbucks.event.vo.in.ProductEventListRequestVo;
import TRaMis8khae.starbucks.media.application.MediaService;
import TRaMis8khae.starbucks.media.entity.Media;
import TRaMis8khae.starbucks.media.entity.MediaKind;
import TRaMis8khae.starbucks.media.entity.MediaType;
import TRaMis8khae.starbucks.media.infrastructure.MediaRepository;
import TRaMis8khae.starbucks.product.application.ProductMediaService;
import TRaMis8khae.starbucks.product.application.ProductService;
import TRaMis8khae.starbucks.product.dto.in.ProductMediaListRequestDto;
import TRaMis8khae.starbucks.product.dto.in.ProductRequestDto;
import TRaMis8khae.starbucks.product.entity.Product;
import TRaMis8khae.starbucks.product.entity.ProductMediaList;
import TRaMis8khae.starbucks.product.infrastructure.ProductMediaListRepository;
import TRaMis8khae.starbucks.product.infrastructure.ProductRepository;
import TRaMis8khae.starbucks.product.vo.in.ProductMediaListRequestVo;
import TRaMis8khae.starbucks.product.vo.in.ProductRequestVo;
import TRaMis8khae.starbucks.review.application.ReviewService;
import TRaMis8khae.starbucks.review.dto.ReviewCrawlingAddDto;
import TRaMis8khae.starbucks.review.dto.ReviewMediaCrawlingAddDto;
import TRaMis8khae.starbucks.review.entity.Review;
import TRaMis8khae.starbucks.review.entity.ReviewMediaList;
import TRaMis8khae.starbucks.review.infrastructure.ReviewMediaListRepository;
import TRaMis8khae.starbucks.review.infrastructure.ReviewRepository;
import TRaMis8khae.starbucks.vendor.application.ProductCategoryListService;
import TRaMis8khae.starbucks.vendor.application.ProductOptionService;
import TRaMis8khae.starbucks.vendor.application.VolumeService;
import TRaMis8khae.starbucks.vendor.dto.in.ProductCategoryListRequestDto;
import TRaMis8khae.starbucks.vendor.dto.in.ProductOptionRequestDto;
import TRaMis8khae.starbucks.vendor.dto.in.VolumeRequestDto;
import TRaMis8khae.starbucks.vendor.entity.ProductCategoryList;
import TRaMis8khae.starbucks.vendor.entity.ProductOption;
import TRaMis8khae.starbucks.vendor.entity.Volume;
import TRaMis8khae.starbucks.vendor.infrastructure.ProductCategoryListRepository;
import TRaMis8khae.starbucks.vendor.vo.in.ProductCategoryListRequestVo;
import TRaMis8khae.starbucks.vendor.vo.in.ProductOptionRequestVo;
import TRaMis8khae.starbucks.vendor.vo.in.VolumeRequestVo;
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
import java.time.LocalDate;
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

    private final ReviewService reviewService;
    private final EventService eventService;
    private final ProductService productService;
    private final ProductCategoryListService productCategoryListService;
    private final MediaService mediaService;
    private final CategoryService categoryService;
    private final ReviewRepository reviewRepository;
    private final EventRepository eventRepository;
    private final ProductRepository productRepository;
    private final ProductCategoryListRepository productCategoryListRepository;
    private final TopCategoryRepository topCategoryRepository;
    private final MiddleCategoryRepository middleCategoryRepository;
    private final BottomCategoryRepository bottomCategoryRepository;

    private final ProductMediaListRepository productMediaListRepository;
    private final ProductMediaService productMediaService;
    private final VolumeService volumeService;
    private final ProductOptionService productOptionService;
    private final MenuCategoryService menuCategoryService;

    @PostConstruct
    public void parseAndSaveData() throws IOException {
        // 엑셀 파일 경로 (예시로 로컬 파일 경로 사용)
        String excelFilePath = "D:\\starbucks_products5.xlsx";

        // 엑셀 데이터 파싱 및 DB 저장
        try {
            log.info("파일 읽기 시작");
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

        // 이벤트 상품 리스트
        List<Product> eventProducts = new ArrayList<>();
        List<Event> events = createEvents();

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

        TopCategoryRequestDto total = parseTopCategory("전체", topCount++);
        String totalTopCode = categoryService.addTopCategory(total);

        TopCategoryRequestDto kitchenTable = parseTopCategory("키친/테이블", topCount++);
        String kitchenTableTopCode = categoryService.addTopCategory(kitchenTable);

        MiddleCategoryRequestDto kitchenTableMid = parseMiddleCategory(kitchenTableTopCode, 0);
        String kitchenTableMidCode = categoryService.addMiddleCategory(kitchenTableMid);

        BottomCategoryRequestDto kitchenTableBot1 = parseBottomCategory(kitchenTableMidCode, tumblr.getSheetName(), 0);
        BottomCategoryRequestDto kitchenTableBot2 = parseBottomCategory(kitchenTableMidCode, mug.getSheetName(), 1);
        String kitchenTableBotCode1 = categoryService.addBottomCategory(kitchenTableBot1);
        String kitchenTableBotCode2 = categoryService.addBottomCategory(kitchenTableBot2);

        TopCategoryRequestDto food = parseTopCategory("푸드", topCount++);
        String foodTopCode = categoryService.addTopCategory(food);

        MiddleCategoryRequestDto foodMid = parseMiddleCategory(foodTopCode, 0);
        String foodMidCode = categoryService.addMiddleCategory(foodMid);

        BottomCategoryRequestDto foodBot1 = parseBottomCategory(foodMidCode, bakery.getSheetName(), 0);
        BottomCategoryRequestDto foodBot2 = parseBottomCategory(foodMidCode, cake.getSheetName(), 1);
        BottomCategoryRequestDto foodBot3 = parseBottomCategory(foodMidCode, sandwich.getSheetName(), 2);
        String foodBotCode1 = categoryService.addBottomCategory(foodBot1);
        String foodBotCode2 = categoryService.addBottomCategory(foodBot2);
        String foodBotCode3 = categoryService.addBottomCategory(foodBot3);

        TopCategoryRequestDto coffeeTea = parseTopCategory("커피/티용품", topCount++);
        String coffeeTeaTopCode = categoryService.addTopCategory(coffeeTea);

        MiddleCategoryRequestDto coffeeTeaMid = parseMiddleCategory(coffeeTeaTopCode, 0);
        String coffeeTeaMidCode = categoryService.addMiddleCategory(coffeeTeaMid);

        BottomCategoryRequestDto coffeeTeaBot = parseBottomCategory(coffeeTeaMidCode, coffee.getSheetName(), 0);
        String coffeeTeaBotCode = categoryService.addBottomCategory(coffeeTeaBot);

        TopCategoryRequestDto lifeStyle = parseTopCategory("라이프스타일", topCount++);
        String lifeStyleTopCode = categoryService.addTopCategory(lifeStyle);

        MiddleCategoryRequestDto lifeStyleMid = parseMiddleCategory(lifeStyleTopCode, 0);
        String lifeStyleMidCode = categoryService.addMiddleCategory(lifeStyleMid);

        BottomCategoryRequestDto lifeStyleBot1 = parseBottomCategory(lifeStyleMidCode, fabric.getSheetName(), 0);
        BottomCategoryRequestDto lifeStyleBot2 = parseBottomCategory(lifeStyleMidCode, homeDeco.getSheetName(), 1);
        BottomCategoryRequestDto lifeStyleBot3 = parseBottomCategory(lifeStyleMidCode, fancy.getSheetName(), 2);
        String lifeStyleBotCode1 = categoryService.addBottomCategory(lifeStyleBot1);
        String lifeStyleBotCode2 = categoryService.addBottomCategory(lifeStyleBot2);
        String lifeStyleBotCode3 = categoryService.addBottomCategory(lifeStyleBot3);

        TopCategoryRequestDto coffeeBeverageGift = parseTopCategory("커피/음료/e-gift", topCount);
        String coffeeBeverageGiftTopCode = categoryService.addTopCategory(coffeeBeverageGift);

        MiddleCategoryRequestDto coffeeBeverageGiftMid = parseMiddleCategory(coffeeBeverageGiftTopCode, 0);
        String coffeeBeverageGiftMidCode = categoryService.addMiddleCategory(coffeeBeverageGiftMid);

        BottomCategoryRequestDto coffeeBeverageGiftBot1 = parseBottomCategory(coffeeBeverageGiftMidCode, drink.getSheetName(), 0);
        BottomCategoryRequestDto coffeeBeverageGiftBot2 = parseBottomCategory(coffeeBeverageGiftMidCode, eGift.getSheetName(), 1);
        String coffeeBeverageGiftBotCode1 = categoryService.addBottomCategory(coffeeBeverageGiftBot1);
        String coffeeBeverageGiftBotCode2 = categoryService.addBottomCategory(coffeeBeverageGiftBot2);

        for (Sheet sheet : workbook) {
            log.info("Sheet name : {}", sheet.getSheetName());
            String categoryName = sheet.getSheetName();
            if (sheet.getSheetName().equals("메뉴 카테고리 이미지")) continue;
            for (Row row : sheet) {
                if(row.getRowNum() == 0) { continue;}
                // media
                String thumbNailMedia = getCellValue(row.getCell(0));
                String mainMedia = getCellValue(row.getCell(6));

                // product
                String productName = getCellValue(row.getCell(1));
                String price = getCellValue(row.getCell(2));
                String descriptionImage = getCellValue(row.getCell(7));
                String descriptionTag = getCellValue(row.getCell(8));

                // event
                String discountRate = getCellValue(row.getCell(4));

                // review
                String readReview = getCellValue(row.getCell(9));

                // media 객체 생성
                List<Media> mediaList = parseMedia(thumbNailMedia, mainMedia);
//                saveMedia(mediaList);


                // product 객체 생성
                ProductRequestDto parsedProduct = parseProduct(productName, Double.parseDouble(price), descriptionImage, descriptionTag);
                String productUUID = productService.addProduct(parsedProduct);

                //product media 객체 생성
                List<Media> productMedia = parseProductDescriptionMedia(descriptionImage);
//                saveMedia(productMedia);

                //product media list 객체 생성
                List<ProductMediaListRequestDto> productMediaLists = parseProductMediaList(productUUID, productMedia);
                for (ProductMediaListRequestDto productMediaList : productMediaLists) {
                    productMediaService.addProductMedia(productMediaList);
                }

                // productCategoryList 객체 생성
                List<ProductCategoryListRequestDto> productCategoryAll = new ArrayList<>();
                productCategoryAll.add(parseProductCategory(productUUID, totalTopCode, null, null));
                String volumeName = "";
                switch (categoryName) {
                case "텀블러-보온병":
                    productCategoryAll.add(parseProductCategory(productUUID, kitchenTableTopCode, kitchenTableMidCode, kitchenTableBotCode1));
                    VolumeRequestDto volumeRequestDto = parseVolume(productName);
                    volumeService.addVolume(volumeRequestDto);
                    volumeName = volumeRequestDto.getName();
                    break;
                case "컵-머그":
                    productCategoryAll.add(parseProductCategory(productUUID, kitchenTableTopCode, kitchenTableMidCode, kitchenTableBotCode2));
                    VolumeRequestDto volumeRequestDto1 = parseVolume(productName);
                    volumeService.addVolume(volumeRequestDto1);
                    volumeName = volumeRequestDto1.getName();

                    break;
                case "베이커리":
                    productCategoryAll.add(parseProductCategory(productUUID, foodTopCode, foodMidCode, foodBotCode1));
                    break;
                case "디저트-케이크":
                    productCategoryAll.add(parseProductCategory(productUUID, foodTopCode, foodMidCode, foodBotCode2));
                    break;
                case "샐러드-샌드위치":
                    productCategoryAll.add(parseProductCategory(productUUID, foodTopCode, foodMidCode, foodBotCode3));
                    break;
                case "커피용품":
                    productCategoryAll.add(parseProductCategory(productUUID, coffeeTeaTopCode, coffeeTeaMidCode, coffeeTeaBotCode));
                    break;
                case "페브릭":
                    productCategoryAll.add(parseProductCategory(productUUID, lifeStyleTopCode, lifeStyleMidCode, lifeStyleBotCode1));
                    break;
                case "홈데코":
                    productCategoryAll.add(parseProductCategory(productUUID, lifeStyleTopCode, lifeStyleMidCode, lifeStyleBotCode2));
                    break;
                case "문구-팬시":
                    productCategoryAll.add(parseProductCategory(productUUID, lifeStyleTopCode, lifeStyleMidCode, lifeStyleBotCode3));
                    break;
                case "음료-요거트":
                    productCategoryAll.add(parseProductCategory(productUUID, coffeeBeverageGiftTopCode, coffeeBeverageGiftMidCode, coffeeBeverageGiftBotCode1));
                    break;
                case "e-gift":
                    productCategoryAll.add(parseProductCategory(productUUID, coffeeBeverageGiftTopCode, coffeeBeverageGiftMidCode, coffeeBeverageGiftBotCode2));
                    break;
                }
                for (ProductCategoryListRequestDto productCategoryListRequestDto : productCategoryAll) {
                    productCategoryListService.addProductByCategory(productCategoryListRequestDto);

                }





                ProductOptionRequestDto productOptionRequestDto = parseProductOption(productUUID, productName, Double.parseDouble(price), volumeName);
                productOptionService.addProductOption(productOptionRequestDto);

                // event 객체 생성
                int discountRateValue = Integer.parseInt(discountRate);

                // discountRate가 0보다 큰 경우에만 저장 처리
                if (discountRateValue > 0) {

                    Event event = Event.builder()
                        .discountRate(discountRateValue)
                        .build();

                    ProductEventList productEventList = ProductEventList.builder()
                        .product(parsedProduct.toEntity(productUUID))
                        .event(event)
                        .build();

                    log.info("!event : {}", event.getDiscountRate());
                    log.info("!productEventList : {}", productEventList.getEvent());
                    log.info("!productEventListProduct : {}", productEventList.getProduct());
                }

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
                            (String) readValue.get("reviewContent"),
                            productUUID
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

                    Review review = reviewDto.toEntity();
                    saveReview(review);
                    saveMedia(reviewMediaList);
                    saveReviewMediaList(review, reviewMediaList);
                    log.info("reviewMediaList : {}", reviewMediaList);
                }
            }
        }


        Sheet sheet = workbook.getSheetAt(11);
        for (Row row : sheet) {
            String catName = getCellValue(row.getCell(0));
            String imageUrl = getCellValue(row.getCell(1));
            log.info(imageUrl);
            List<MenuCategoryRequestDto> menuCategoryAll = new ArrayList<>();
            switch (catName) {
            case "텀블러/보온병":
                menuCategoryAll.add(parseMenuCategory(kitchenTableTopCode, imageUrl));
                break;

            case "컵/머그":
                menuCategoryAll.add(parseMenuCategory(kitchenTableTopCode, imageUrl));
                break;

            case "커피/티용품":
                menuCategoryAll.add(parseMenuCategory(coffeeTeaTopCode, imageUrl));

                break;


            case "라이프스타일":
                menuCategoryAll.add(parseMenuCategory(lifeStyleTopCode, imageUrl));

                break;

            case "e-gift":
                menuCategoryAll.add(parseMenuCategory(coffeeBeverageGiftTopCode, imageUrl));

                break;

            case "디저트":
                menuCategoryAll.add(parseMenuCategory(foodTopCode, imageUrl));

                break;

            case "베이커리":
                menuCategoryAll.add(parseMenuCategory(foodTopCode, imageUrl));

                break;

             

            case "음료/요거트":
                menuCategoryAll.add(parseMenuCategory(coffeeBeverageGiftTopCode, imageUrl));

                break;

            default:
                break;
            }
            for (MenuCategoryRequestDto menuCategoryRequestDto : menuCategoryAll) {
                menuCategoryService.addMenuCategory(menuCategoryRequestDto);

            }

            // event

            int productIndex = 0;

            for (Event event : events) {

                for (int i = 0; i < 5; i++) {
                    Product product = eventProducts.get(productIndex++);

                    ProductEventList productEventList = ProductEventList.builder()
                            .product(product)
                            .event(event)
                            .build();

                    eventService.addCrawlEventProduct(productEventList);
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
    public VolumeRequestDto parseVolume(String productName) {
        String name = "";
        int vol = 0;
        int index = productName.indexOf("ml");
        if (index!= -1) {
            if (productName.charAt(index - 3) == ' ') {
                vol = Integer.parseInt(productName.substring(index - 2, index));
            } else {
                vol = Integer.parseInt(productName.substring(index - 3, index));
            }


            if (vol <= 345) {
                name = "Short";
            } else if (vol <= 444) {
                name = "Tall";
            } else if (vol <= 590) {
                name = "Grande";
            } else if (vol <= 710) {
                name = "Venti";
            }
        }

        return VolumeRequestDto.toDto(VolumeRequestVo.builder()
            .name(name)
            .build());

    }

    public List<Media> parseProductDescriptionMedia(String description) {

        List<String> mediaUrls = Arrays.stream(description.split(","))
            .map(String::trim) // 각 URL에서 공백 제거
            .toList();

        List<Media> mediaList = new ArrayList<>();

        int count = 0;
        for (String mediaUrl : mediaUrls) {
            Media media = Media.builder()
                .mediaUrl(mediaUrl)
                .thumbChecked(Boolean.FALSE)
                .mediaType(MediaType.IMAGE)
                .mediaKind(MediaKind.PRODUCT)
                .mediaSeq(count++)
                .build();
            mediaList.add(media);

        }
        return mediaList;

    }


    public List<ProductMediaListRequestDto> parseProductMediaList(String productUUID, List<Media> medias) {

        List<ProductMediaListRequestDto> productMediaLists = new ArrayList<>();
        for (Media media : medias) {

            productMediaLists.add(ProductMediaListRequestDto.toDto(
                ProductMediaListRequestVo.builder()
                    .mediaId(media.getId())
                    .productUUID(productUUID)
                    .build()));
        }

        return productMediaLists;
    }

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

    public ProductRequestDto parseProduct(String productName, Double price, String descriptionImage,
        String descriptionTag) {
        return ProductRequestDto.toDto(ProductRequestVo.builder()
            .productName(productName)
            .price(price)
            .description(descriptionTag)
            .additionalChecked(Boolean.FALSE)
            .isAdditionalTogether(Boolean.FALSE)
            .engravingChecked(Boolean.FALSE)
            .maxOrderCount(3)
            .build());
    }

    public TopCategoryRequestDto parseTopCategory(String categoryName, Integer sequence) {
        return TopCategoryRequestDto.toDto(TopCategoryRequestVo.builder()
            .name(categoryName)
            .sequence(sequence)
            .build());
    }

    public MiddleCategoryRequestDto parseMiddleCategory(String topCode, Integer sequence) {
        return MiddleCategoryRequestDto.toDto(MiddleCategoryRequestVo.builder()
            .topCategoryCode(topCode)
            .name("카테고리")
            .sequence(sequence)
            .build());
    }

    public BottomCategoryRequestDto parseBottomCategory(String midCode, String name, Integer sequence) {
        return BottomCategoryRequestDto.toDto(BottomCategoryRequestVo.builder()
            .middleCategoryCode(midCode)
            .name(name)
            .sequence(sequence)
            .build());
    }

    public ProductCategoryListRequestDto parseProductCategory(String uuid, String topCode, String middleCode, String bottomCode) {
        return ProductCategoryListRequestDto.toDto(ProductCategoryListRequestVo.builder()
            .productUUID(uuid)
            .topCode(topCode)
            .middleCode(middleCode)
            .bottomCode(bottomCode)
            .build());
    }

    public ProductOptionRequestDto parseProductOption(String uuid, String productName, Double price, String volumeName) {

        return ProductOptionRequestDto.toDto(ProductOptionRequestVo.builder()
            .productUUID(uuid)
            .productName(productName)
            .price(price)
            .stockQuantity(1000)
            .limitCnt(3)
            .soldOutChecked(Boolean.FALSE)
            .openChecked(Boolean.TRUE)
            .closedChecked(Boolean.FALSE)
            .volumeName(volumeName)
            .build());
    }


    public MenuCategoryRequestDto parseMenuCategory(String topCode, String imageUrl) {

        return MenuCategoryRequestDto.toDto(MenuCategoryRequestVo.builder()
            .topCode(topCode)
            .imageUrl(imageUrl)
            .build());
    }

    // -------------------------------- save methods --------------------------------
    private void saveTopCategory(TopCategory topCategory) {
//        categoryService.save(topCategory);
    }


    private void saveBottomCategory(BottomCategory bottomCategory) {
//        categoryService.save(bottomCategory);

    }

    private void saveMiddleCategory(MiddleCategory middleCategory) {
//        categoryService.save(middleCategory);

//        middleCategoryRepository.save(middleCategory);
    }

    private void saveProductCategoryList(List<ProductCategoryList> productCategoryAll) {
//        productCategoryListService.saveAll(productCategoryAll);
    }
    private void saveProduct(Product product) {
//        productService.save(product);
    }

    private void saveMedia(List<Media> mediaList) {
//        mediaService.saveAll(mediaList);
    }

    private void saveEvent(Event event) {
//        eventService.save(event);
    }

    private void saveReview(Review review) {
//        reviewService.save(review);
    }

    private void saveReviewMediaList(Review review, List<Media> reviewMediaList) {
//        for (Media media : reviewMediaList) {
//            reviewMediaListRepository.save(ReviewMediaCrawlingAddDto.toDto(media.getId(), review).toEntity());
//        }
    }

    private List<Event> createEvents() {
        List<Event> events = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            int discountRate = 5;
            String eventName = "event" + i;

            if (eventService.findByEventName(eventName).isPresent()) {
                continue;
            }

            Event event = Event.builder()
                    .eventName(eventName)
                    .discountRate(discountRate)
                    .startDate(LocalDate.now())
                    .endDate(LocalDate.now().plusDays(7))
                    .build();

//            EventRequestVo requestVo = EventRequestVo.builder()
//                    .eventName(eventName)
//                    .discountRate(discountRate)
//                    .startDate(LocalDate.now())
//                    .endDate(LocalDate.now().plusDays(7))
//                    .discountRate(discountRate)
//                    .build();
//
//            EventRequestDto requestDto = EventRequestDto.toDto(requestVo);

            eventService.addCrawlEvent(event);
            events.add(event);
        }
        return events;
    }

    private void saveProductMedia(List<ProductMediaList> productMediaList) {
        productMediaListRepository.saveAll(productMediaList);

    }
}