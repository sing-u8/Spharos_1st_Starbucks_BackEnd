package TRaMis8khae.starbucks.admin.presentation;

import TRaMis8khae.starbucks.admin.application.CategoryService;
import TRaMis8khae.starbucks.admin.dto.in.MainCategoryRequestDto;
import TRaMis8khae.starbucks.admin.dto.in.SubCategoryRequestDto;
import TRaMis8khae.starbucks.admin.dto.out.MainCategoryResponseDto;
import TRaMis8khae.starbucks.admin.dto.out.SubCategoryResponseDto;
import TRaMis8khae.starbucks.admin.vo.MainCategoryRequestVo;
import TRaMis8khae.starbucks.admin.vo.MainCategoryResponseVo;
import TRaMis8khae.starbucks.admin.vo.SubCategoryRequestVo;
import TRaMis8khae.starbucks.admin.vo.SubCategoryResponseVo;
import TRaMis8khae.starbucks.common.entity.CommonResponseEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/main-category")
    public CommonResponseEntity<Void> createMainCategory(@RequestBody MainCategoryRequestVo mainCategoryRequestVo) {
        categoryService.addMainCategory(MainCategoryRequestDto.toDto(mainCategoryRequestVo));
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                "카테고리 등록 성공",
                null
        );
    }

    @PostMapping("/sub-category")
    public CommonResponseEntity<Void> createSubCategory(@RequestBody SubCategoryRequestVo subCategoryRequestVo) {
        System.out.println(subCategoryRequestVo.getSubCategoryName());
        categoryService.addSubCategory(SubCategoryRequestDto.toDto(subCategoryRequestVo));
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                "카테고리 등록 성공",
                null
        );
    }

    @GetMapping("/main-category/{mainId}")
    public CommonResponseEntity<MainCategoryResponseVo> getMainCategory(@PathVariable Integer mainId) {
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                "메인 카테고리 조회 성공",
                categoryService.findMainCategoryById(mainId).toVo()
        );
    }

    @GetMapping("/sub-category/{subId}")
    public CommonResponseEntity<SubCategoryResponseVo> getSubCategory(@PathVariable Integer subId) {
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                "서브 카테고리 조회 성공",
                categoryService.findSubCategoryById(subId).toVo()
        );
    }

    @GetMapping("/main-categories")
    public CommonResponseEntity<List<MainCategoryResponseVo>> getMainCategories() {
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                "메인 카테고리 리스트 조회 성공",
                categoryService.findMainCategories().stream().map(MainCategoryResponseDto::toVo).toList()
        );
    }

    @GetMapping("/sub-categories/{mainId}")
    public CommonResponseEntity<List<SubCategoryResponseVo>> getSubCategories(@PathVariable Integer mainId) {
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                "서브 카테고리 리스트 조회 성공",
                categoryService.findSubCategories(mainId).stream().map(SubCategoryResponseDto::toVo).toList()
        );
    }
}
