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
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "top 카테고리 생성", description = "top 카테고리를 생성합니다", tags = {"Category Service"})
    @PostMapping("/top")
    public BaseResponse<Void> createTopCategory(@RequestBody TopCategoryRequestVo topCategoryRequestVo) {

        categoryService.addTopCategory(TopCategoryRequestDto.toDto(topCategoryRequestVo));

        return new BaseResponse<>();
    }

    @Operation(summary = "middle 카테고리 생성", description = "middle 카테고리를 생성합니다", tags = {"Category Service"})
    @PostMapping("/middle")
    public BaseResponse<Void> createMiddleCategory(@RequestBody MiddleCategoryRequestVo middleCategoryRequestVo) {

        categoryService.addMiddleCategory(MiddleCategoryRequestDto.toDto(middleCategoryRequestVo));

        return new BaseResponse<>();
    }


    @Operation(summary = "bottom 카테고리 생성", description = "bottom 카테고리를 생성합니다", tags = {"Category Service"})
    @PostMapping("/bottom")
    public BaseResponse<Void> createBottomCategory(@RequestBody BottomCategoryRequestVo bottomCategoryRequestVo) {

        categoryService.addBottomCategory(BottomCategoryRequestDto.toDto(bottomCategoryRequestVo));

        return new BaseResponse<>();
    }

    @Operation(summary = "top 카테고리 조회", description = "top 카테고리를 조회합니다", tags = {"Category Service"})
    @GetMapping("/top/{topCode}")
    public BaseResponse<TopCategoryResponseVo> getTopCategory(@PathVariable String topCode) {

        return new BaseResponse<>(categoryService.findTopCategoryByCode(topCode).toVo());
    }

    @Operation(summary = "middle 카테고리 조회", description = "middle 카테고리를 조회합니다", tags = {"Category Service"})
    @GetMapping("/middle/{middleCode}")
    public BaseResponse<MiddleCategoryResponseVo> getMiddleCategory(@PathVariable String middleCode) {

        return new BaseResponse<>(categoryService.findMiddleCategoryByCode(middleCode).toVo());
    }

    @Operation(summary = "bottom 카테고리 조회", description = "bottom 카테고리를 조회합니다", tags = {"Category Service"})
    @GetMapping("/bottom/{bottomCode}")
    public BaseResponse<BottomCategoryResponseVo> getBottomCategory(@PathVariable String bottomCode) {

        return new BaseResponse<>(categoryService.findBottomCategoryByCode(bottomCode).toVo());
    }

    @Operation(summary = "top 카테고리 리스트 조회", description = "top 카테고리 리스트를 조회합니다", tags = {"Category Service"})
    @GetMapping("/topCategories")
    public BaseResponse<List<TopCategoryResponseVo>> getTopCategories() {

        return new BaseResponse<>(categoryService.findTopCategories().stream().map(TopCategoryResponseDto::toVo).toList());
    }

    @Operation(summary = "middle 카테고리 리스트 조회", description = "middle 카테고리 리스트를 조회합니다", tags = {"Category Service"})
    @GetMapping("/{topCode}/middleCategories")
    public BaseResponse<List<MiddleCategoryResponseVo>> getSubCategories(@PathVariable String topCode) {

        return new BaseResponse<>(categoryService.findMiddleCategories(topCode).stream().map(MiddleCategoryResponseDto::toVo).toList());
    }

    @Operation(summary = "bottom 카테고리 리스트 조회", description = "bottom 카테고리 리스트를 조회합니다", tags = {"Category Service"})
    @GetMapping("/{middleCode}/bottomCategories")
    public BaseResponse<List<BottomCategoryResponseVo>> getBottomCategories(@PathVariable String middleCode) {

        return new BaseResponse<>(categoryService.findBottomCategories(middleCode).stream().map(BottomCategoryResponseDto::toVo).toList());
    }

}