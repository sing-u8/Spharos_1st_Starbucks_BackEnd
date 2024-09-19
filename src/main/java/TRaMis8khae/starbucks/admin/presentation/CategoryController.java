package TRaMis8khae.starbucks.admin.presentation;

import TRaMis8khae.starbucks.admin.application.CategoryService;
import TRaMis8khae.starbucks.admin.dto.in.BottomCategoryRequestDto;
import TRaMis8khae.starbucks.admin.dto.in.TopCategoryRequestDto;
import TRaMis8khae.starbucks.admin.dto.in.MiddleCategoryRequestDto;
import TRaMis8khae.starbucks.admin.dto.out.BottomCategoryResponseDto;
import TRaMis8khae.starbucks.admin.dto.out.TopCategoryResponseDto;
import TRaMis8khae.starbucks.admin.dto.out.MiddleCategoryResponseDto;
import TRaMis8khae.starbucks.admin.vo.*;
import TRaMis8khae.starbucks.common.entity.BaseResponse;
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
    public BaseResponse<Void> createTopCategory(@RequestBody TopCategoryRequestVo topCategoryRequestVo) {

        categoryService.addTopCategory(TopCategoryRequestDto.toDto(topCategoryRequestVo));

        return new BaseResponse<>();
    }

    @PostMapping("/middle")
    public BaseResponse<Void> createMiddleCategory(@RequestBody MiddleCategoryRequestVo middleCategoryRequestVo) {

        categoryService.addMiddleCategory(MiddleCategoryRequestDto.toDto(middleCategoryRequestVo));

        return new BaseResponse<>();
    }


    @PostMapping("/bottom")
    public BaseResponse<Void> createBottomCategory(@RequestBody BottomCategoryRequestVo bottomCategoryRequestVo) {

        categoryService.addBottomCategory(BottomCategoryRequestDto.toDto(bottomCategoryRequestVo));

        return new BaseResponse<>();
    }

    @GetMapping("/top/{topCode}")
    public BaseResponse<TopCategoryResponseVo> getTopCategory(@PathVariable String topCode) {

        return new BaseResponse<>(categoryService.findTopCategoryByCode(topCode).toVo());
    }

    @GetMapping("/middle/{middleCode}")
    public BaseResponse<MiddleCategoryResponseVo> getMiddleCategory(@PathVariable String middleCode) {

        return new BaseResponse<>(categoryService.findMiddleCategoryByCode(middleCode).toVo());
    }

    @GetMapping("/bottom/{bottomCode}")
    public BaseResponse<BottomCategoryResponseVo> getBottomCategory(@PathVariable String bottomCode) {

        return new BaseResponse<>(categoryService.findBottomCategoryByCode(bottomCode).toVo());
    }


    @GetMapping("/topCategories")
    public BaseResponse<List<TopCategoryResponseVo>> getTopCategories() {

        return new BaseResponse<>(categoryService.findTopCategories().stream().map(TopCategoryResponseDto::toVo).toList());
    }

    @GetMapping("/{topCode}/middleCategories")
    public BaseResponse<List<MiddleCategoryResponseVo>> getSubCategories(@PathVariable String topCode) {

        return new BaseResponse<>(categoryService.findMiddleCategories(topCode).stream().map(MiddleCategoryResponseDto::toVo).toList());
    }

    @GetMapping("/{middleCode}/bottomCategories")
    public BaseResponse<List<BottomCategoryResponseVo>> getBottomCategories(@PathVariable String middleCode) {

        return new BaseResponse<>(categoryService.findBottomCategories(middleCode).stream().map(BottomCategoryResponseDto::toVo).toList());
    }

}