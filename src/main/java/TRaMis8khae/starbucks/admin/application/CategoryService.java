package TRaMis8khae.starbucks.admin.application;

import TRaMis8khae.starbucks.admin.dto.in.MainCategoryRequestDto;
import TRaMis8khae.starbucks.admin.dto.in.SubCategoryRequestDto;
import TRaMis8khae.starbucks.admin.dto.out.MainCategoryResponseDto;
import TRaMis8khae.starbucks.admin.dto.out.SubCategoryResponseDto;

import java.util.List;

public interface CategoryService {

    void addMainCategory(MainCategoryRequestDto requestDto);
    void addSubCategory(SubCategoryRequestDto requestDto);

    MainCategoryResponseDto findMainCategoryById(Integer id);
    MainCategoryResponseDto findMainCategoryByName(String name);
    MainCategoryResponseDto findMainCategoryByCode(String code);

    SubCategoryResponseDto findSubCategoryById(Integer id);
    SubCategoryResponseDto findSubCategoryByName(String name);
    SubCategoryResponseDto findSubCategoryByCode(String code);

    List<MainCategoryResponseDto> findMainCategories();
    List<SubCategoryResponseDto> findSubCategories(String mainCategoryCode);

}