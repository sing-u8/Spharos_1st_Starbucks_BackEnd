package TRaMis8khae.starbucks.admin.application;

import TRaMis8khae.starbucks.admin.dto.in.MainCategoryRequestDto;
import TRaMis8khae.starbucks.admin.dto.in.SubCategoryRequestDto;
import TRaMis8khae.starbucks.admin.dto.out.MainCategoryResponseDto;
import TRaMis8khae.starbucks.admin.dto.out.SubCategoryResponseDto;
import TRaMis8khae.starbucks.admin.entity.MainCategory;
import TRaMis8khae.starbucks.admin.entity.SubCategory;
import TRaMis8khae.starbucks.admin.infrastructure.MainCategoryRepository;
import TRaMis8khae.starbucks.admin.infrastructure.SubCategoryRepository;
import TRaMis8khae.starbucks.common.utils.CategoryCodeGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final MainCategoryRepository mainCategoryRepository;
    private final SubCategoryRepository subCategoryRepository;

    @Override
    public void addMainCategory(MainCategoryRequestDto requestDto) {
        
        mainCategoryRepository.save(requestDto.toEntity(
            CategoryCodeGenerator.generateCategoryCode())
        );
    }

    @Override
    public void addSubCategory(SubCategoryRequestDto requestDto) {

        MainCategory mainCategory = mainCategoryRepository.findByCode(requestDto.getMainCategoryCode())
            .orElseThrow(
                () -> new IllegalArgumentException("해당 카테고리가 존재하지 않습니다.")
        );

        subCategoryRepository.save(requestDto.toEntity(
            mainCategory, CategoryCodeGenerator.generateCategoryCode()))
        ;
    }

    @Override
    public MainCategoryResponseDto findMainCategoryById(Integer id) {

        MainCategory mainCategory = mainCategoryRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 카테고리가 존재하지 않습니다.")
        );

        return MainCategoryResponseDto.toDto(mainCategory);
    }

    @Override
    public MainCategoryResponseDto findMainCategoryByName(String name) {

        MainCategory mainCategory = mainCategoryRepository.findByName(name).orElseThrow(
                () -> new IllegalArgumentException("해당 카테고리가 존재하지 않습니다.")
        );

        return MainCategoryResponseDto.toDto(mainCategory);
    }

    @Override
    public MainCategoryResponseDto findMainCategoryByCode(String code) {

        MainCategory mainCategory = mainCategoryRepository.findByCode(code).orElseThrow(
                () -> new IllegalArgumentException("해당 카테고리가 존재하지 않습니다.")
        );

        return MainCategoryResponseDto.toDto(mainCategory);
    }

    @Override
    public SubCategoryResponseDto findSubCategoryById(Integer id) {

        SubCategory subCategory = subCategoryRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 카테고리가 존재하지 않습니다.")
        );

        return SubCategoryResponseDto.toDto(subCategory);
    }

    @Override
    public SubCategoryResponseDto findSubCategoryByName(String name) {

        SubCategory subCategory = subCategoryRepository.findByName(name).orElseThrow(
                () -> new IllegalArgumentException("해당 카테고리가 존재하지 않습니다.")
        );

        return SubCategoryResponseDto.toDto(subCategory);
    }

    @Override
    public SubCategoryResponseDto findSubCategoryByCode(String code) {

        SubCategory subCategory = subCategoryRepository.findByCode(code).orElseThrow(
                () -> new IllegalArgumentException("해당 카테고리가 존재하지 않습니다.")
        );

        return SubCategoryResponseDto.toDto(subCategory);
    }

    @Override
    public List<MainCategoryResponseDto> findMainCategories() {

        List<MainCategory> mainCategories = mainCategoryRepository.findAll();

        return mainCategories.stream().map(MainCategoryResponseDto::toDto).toList();
    }

    @Override
    public List<SubCategoryResponseDto> findSubCategories(String mainCategoryCode) {

        List<SubCategory> subCategories = subCategoryRepository.findByMainCategoryCode(mainCategoryCode);

        return subCategories.stream().map(SubCategoryResponseDto::toDto).toList();
    }

}