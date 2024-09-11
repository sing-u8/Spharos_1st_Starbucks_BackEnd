package TRaMis8khae.starbucks.admin.presentation;

import TRaMis8khae.starbucks.admin.application.CategoryService;
import TRaMis8khae.starbucks.admin.dto.in.TopCategoryRequestDto;
import TRaMis8khae.starbucks.admin.dto.in.MiddleCategoryRequestDto;
import TRaMis8khae.starbucks.admin.dto.out.TopCategoryResponseDto;
import TRaMis8khae.starbucks.admin.dto.out.MiddleCategoryResponseDto;
import TRaMis8khae.starbucks.admin.vo.TopCategoryRequestVo;
import TRaMis8khae.starbucks.admin.vo.TopCategoryResponseVo;
import TRaMis8khae.starbucks.admin.vo.MiddleCategoryRequestVo;
import TRaMis8khae.starbucks.admin.vo.MiddleCategoryResponseVo;
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
    public CommonResponseEntity<Void> createTopCategory(@RequestBody TopCategoryRequestVo TopCategoryRequestVo) {

        categoryService.addTopCategory(TopCategoryRequestDto.toDto(TopCategoryRequestVo));

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                null
        );
    }

    @PostMapping("/sub")
    public CommonResponseEntity<Void> createMiddleCategory(@RequestBody MiddleCategoryRequestVo MiddleCategoryRequestVo) {

        System.out.println(MiddleCategoryRequestVo.getName());

        categoryService.addMiddleCategory(MiddleCategoryRequestDto.toDto(MiddleCategoryRequestVo));

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                null
        );
    }

    @GetMapping("/main/{code}")
    public CommonResponseEntity<TopCategoryResponseVo> getTopCategory(@PathVariable String code) {

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                categoryService.findTopCategoryByCode(code).toVo()
        );
    }

    @GetMapping("/sub/{code}")
    public CommonResponseEntity<MiddleCategoryResponseVo> getMiddleCategory(@PathVariable String code) {

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                categoryService.findMiddleCategoryByCode(code).toVo()
        );
    }

    @GetMapping("/main-categories")
    public CommonResponseEntity<List<TopCategoryResponseVo>> getTopCategories() {

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                categoryService.findTopCategories().stream().map(TopCategoryResponseDto::toVo).toList()
        );
    }

    @GetMapping("/{mainCode}/sub-categories")
    public CommonResponseEntity<List<MiddleCategoryResponseVo>> getSubCategories(@PathVariable String mainCode) {

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                categoryService.findMiddleCategories(mainCode).stream().map(MiddleCategoryResponseDto::toVo).toList()
        );
    }

}