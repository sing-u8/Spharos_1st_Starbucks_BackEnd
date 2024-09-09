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
import TRaMis8khae.starbucks.common.entity.CommonResponseMessage;
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

    @PostMapping("/main")
    public CommonResponseEntity<Void> createMainCategory(@RequestBody MainCategoryRequestVo mainCategoryRequestVo) {

        categoryService.addMainCategory(MainCategoryRequestDto.toDto(mainCategoryRequestVo));

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                null
        );
    }

    @PostMapping("/sub")
    public CommonResponseEntity<Void> createSubCategory(@RequestBody SubCategoryRequestVo subCategoryRequestVo) {

        System.out.println(subCategoryRequestVo.getName());

        categoryService.addSubCategory(SubCategoryRequestDto.toDto(subCategoryRequestVo));

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                null
        );
    }

    @GetMapping("/main/{code}")
    public CommonResponseEntity<MainCategoryResponseVo> getMainCategory(@PathVariable String code) {

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                categoryService.findMainCategoryByCode(code).toVo()
        );
    }

    @GetMapping("/sub/{code}")
    public CommonResponseEntity<SubCategoryResponseVo> getSubCategory(@PathVariable String code) {

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                categoryService.findSubCategoryByCode(code).toVo()
        );
    }

    @GetMapping("/main-categories")
    public CommonResponseEntity<List<MainCategoryResponseVo>> getMainCategories() {

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                categoryService.findMainCategories().stream().map(MainCategoryResponseDto::toVo).toList()
        );
    }

    @GetMapping("/{mainCode}/sub-categories")
    public CommonResponseEntity<List<SubCategoryResponseVo>> getSubCategories(@PathVariable String mainCode) {

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                categoryService.findSubCategories(mainCode).stream().map(SubCategoryResponseDto::toVo).toList()
        );
    }

}