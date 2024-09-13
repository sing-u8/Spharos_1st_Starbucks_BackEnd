package TRaMis8khae.starbucks.admin.application;

import TRaMis8khae.starbucks.admin.dto.in.BottomCategoryRequestDto;
import TRaMis8khae.starbucks.admin.dto.in.TopCategoryRequestDto;
import TRaMis8khae.starbucks.admin.dto.in.MiddleCategoryRequestDto;
import TRaMis8khae.starbucks.admin.dto.out.BottomCategoryResponseDto;
import TRaMis8khae.starbucks.admin.dto.out.TopCategoryResponseDto;
import TRaMis8khae.starbucks.admin.dto.out.MiddleCategoryResponseDto;

import java.util.List;

public interface CategoryService {

    void addTopCategory(TopCategoryRequestDto requestDto);
    void addMiddleCategory(MiddleCategoryRequestDto requestDto);
    void addBottomCategory(BottomCategoryRequestDto requestDto);


    TopCategoryResponseDto findTopCategoryByName(String name);
    TopCategoryResponseDto findTopCategoryByCode(String code);


    MiddleCategoryResponseDto findMiddleCategoryByName(String name);
    MiddleCategoryResponseDto findMiddleCategoryByCode(String code);


    BottomCategoryResponseDto findBottomCategoryByName(String name);
    BottomCategoryResponseDto findBottomCategoryByCode(String code);

    List<TopCategoryResponseDto> findTopCategories();

    List<MiddleCategoryResponseDto> findMiddleCategories(String TopCategoryCode);

    List<BottomCategoryResponseDto> findBottomCategories(String MiddleCategoryCode);

}