package TRaMis8khae.starbucks.admin.application;

import TRaMis8khae.starbucks.admin.dto.in.MainCategoryRequestDto;
import TRaMis8khae.starbucks.admin.dto.in.SubCategoryRequestDto;
import TRaMis8khae.starbucks.admin.dto.out.MainCategoryResponseDto;
import TRaMis8khae.starbucks.admin.dto.out.SubCategoryResponseDto;

import java.util.List;

public interface CategoryService {

    void addMainCategory(MainCategoryRequestDto requestDto);
    void addSubCategory(SubCategoryRequestDto requestDto);

    void updateMainCategory(MainCategoryRequestDto requestDto);
    void updateSubCategory(SubCategoryRequestDto requestDto);

    void deleteMainCategory(Integer MainCategoryId);
    void deleteSubCategory(Integer SubCategoryId);

    MainCategoryResponseDto findMainCategoryById(Integer MainCategoryId);
    MainCategoryResponseDto findMainCategoryByName(String MainCategoryName);

    SubCategoryResponseDto findSubCategoryById(Integer SubCategoryId);
    SubCategoryResponseDto findSubCategoryByName(String SubCategoryName);

    List<MainCategoryResponseDto> findMainCategories();
    List<SubCategoryResponseDto> findSubCategories(Integer mainCategoryId);

}