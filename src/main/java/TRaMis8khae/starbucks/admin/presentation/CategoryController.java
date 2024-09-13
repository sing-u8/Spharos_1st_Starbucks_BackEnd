package TRaMis8khae.starbucks.admin.presentation;

import TRaMis8khae.starbucks.admin.application.CategoryService;
import TRaMis8khae.starbucks.admin.dto.in.BottomCategoryRequestDto;
import TRaMis8khae.starbucks.admin.dto.in.TopCategoryRequestDto;
import TRaMis8khae.starbucks.admin.dto.in.MiddleCategoryRequestDto;
import TRaMis8khae.starbucks.admin.dto.out.BottomCategoryResponseDto;
import TRaMis8khae.starbucks.admin.dto.out.TopCategoryResponseDto;
import TRaMis8khae.starbucks.admin.dto.out.MiddleCategoryResponseDto;
import TRaMis8khae.starbucks.admin.vo.*;
import TRaMis8khae.starbucks.common.entity.CommonResponseEntity;
import TRaMis8khae.starbucks.common.entity.CommonResponseMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.type.BottomType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/top")
    public CommonResponseEntity<Void> createTopCategory(@RequestBody TopCategoryRequestVo topCategoryRequestVo) {

        categoryService.addTopCategory(TopCategoryRequestDto.toDto(topCategoryRequestVo));

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                null
        );
    }

    @PostMapping("/middle")
    public CommonResponseEntity<Void> createMiddleCategory(@RequestBody MiddleCategoryRequestVo middleCategoryRequestVo) {

        categoryService.addMiddleCategory(MiddleCategoryRequestDto.toDto(middleCategoryRequestVo));

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                null
        );
    }


    @PostMapping("/bottom")
    public CommonResponseEntity<Void> createBottomCategory(@RequestBody BottomCategoryRequestVo bottomCategoryRequestVo) {

        categoryService.addBottomCategory(BottomCategoryRequestDto.toDto(bottomCategoryRequestVo));

        return new CommonResponseEntity<>(
            HttpStatus.OK,
            true,
            CommonResponseMessage.SUCCESS.getMessage(),
            null
        );
    }

    @GetMapping("/top/{topCode}")
    public CommonResponseEntity<TopCategoryResponseVo> getTopCategory(@PathVariable String topCode) {

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                categoryService.findTopCategoryByCode(topCode).toVo()
        );
    }

    @GetMapping("/middle/{middleCode}")
    public CommonResponseEntity<MiddleCategoryResponseVo> getMiddleCategory(@PathVariable String middleCode) {

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                categoryService.findMiddleCategoryByCode(middleCode).toVo()
        );
    }

    @GetMapping("/bottom/{bottomCode}")
    public CommonResponseEntity<BottomCategoryResponseVo> getBottomCategory(@PathVariable String bottomCode) {

        return new CommonResponseEntity<>(
            HttpStatus.OK,
            true,
            CommonResponseMessage.SUCCESS.getMessage(),
            categoryService.findBottomCategoryByCode(bottomCode).toVo()
        );
    }


    @GetMapping("/topCategories")
    public CommonResponseEntity<List<TopCategoryResponseVo>> getTopCategories() {

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                categoryService.findTopCategories().stream().map(TopCategoryResponseDto::toVo).toList()
        );
    }

    @GetMapping("/{topCode}/middleCategories")
    public CommonResponseEntity<List<MiddleCategoryResponseVo>> getSubCategories(@PathVariable String topCode) {

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                categoryService.findMiddleCategories(topCode).stream().map(MiddleCategoryResponseDto::toVo).toList()
        );
    }

    @GetMapping("/{middleCode}/bottomCategories")
    public CommonResponseEntity<List<BottomCategoryResponseVo>> getBottomCategories(@PathVariable String middleCode) {

        return new CommonResponseEntity<>(
            HttpStatus.OK,
            true,
            CommonResponseMessage.SUCCESS.getMessage(),
            categoryService.findBottomCategories(middleCode).stream().map(BottomCategoryResponseDto::toVo).toList()
        );
    }

}