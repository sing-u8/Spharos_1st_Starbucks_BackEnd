package TRaMis8khae.starbucks.admin.application;

import TRaMis8khae.starbucks.admin.dto.in.MainCategoryRequestDto;
import TRaMis8khae.starbucks.admin.dto.in.SubCategoryRequestDto;
import TRaMis8khae.starbucks.admin.dto.out.MainCategoryResponseDto;
import TRaMis8khae.starbucks.admin.dto.out.SubCategoryResponseDto;
import TRaMis8khae.starbucks.admin.entity.MainCategory;
import TRaMis8khae.starbucks.admin.entity.SubCategory;
import TRaMis8khae.starbucks.admin.infrastructure.MainCategoryRepository;
import TRaMis8khae.starbucks.admin.infrastructure.SubCategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private MainCategoryRepository mainCategoryRepository;
    private SubCategoryRepository subCategoryRepository;

    @Override
    public void addMainCategory(MainCategoryRequestDto requestDto) {
        if (mainCategoryRepository.existsByCategoryName(requestDto.getMainCategoryName())) {
            throw new IllegalArgumentException("해당 카테고리가 이미 존재합니다.");
        }
        mainCategoryRepository.save(requestDto.toEntity());
    }

    @Override
    public void addSubCategory(SubCategoryRequestDto requestDto) {
        if (subCategoryRepository.existsByCategoryName(requestDto.getSubCategoryName())) {
            throw new IllegalArgumentException("해당 카테고리가 이미 존재합니다.");
        }
        MainCategory mainCategory = mainCategoryRepository.findById(
                requestDto.getMainCategoryId()).orElseThrow(
                        () -> new IllegalArgumentException("해당 카테고리가 존재하지 않습니다.")
        );

        subCategoryRepository.save(requestDto.toEntity(mainCategory));
    }

    @Override
    public void updateMainCategory(MainCategoryRequestDto requestDto) {
        mainCategoryRepository.save(requestDto.toEntity());
    }

    @Override
    public void updateSubCategory(SubCategoryRequestDto requestDto) {
        MainCategory mainCategory = mainCategoryRepository.findById(
                requestDto.getMainCategoryId()).orElseThrow(
                () -> new IllegalArgumentException("해당 카테고리가 존재하지 않습니다.")
        );

        subCategoryRepository.save(requestDto.toEntity(mainCategory));
    }

    @Override
    public void deleteMainCategory(Integer MainCategoryId) {
        mainCategoryRepository.deleteById(MainCategoryId);
    }

    @Override
    public void deleteSubCategory(Integer SubCategoryId) {
        subCategoryRepository.deleteById(SubCategoryId);

    }

    @Override
    public MainCategoryResponseDto findMainCategoryById(Integer mainCategoryId) {
        MainCategory mainCategory = mainCategoryRepository.findById(mainCategoryId)
                .orElseThrow(() -> new IllegalArgumentException("해당 카테고리가 존재하지 않습니다."));
        return MainCategoryResponseDto.builder()
                .mainCategoryOrder(mainCategory.getMainCategoryOrder())
                .mainCategoryName(mainCategory.getMainCategoryName())
                .build();
    }

    @Override
    public MainCategoryResponseDto findMainCategoryByName(String mainCategoryName) {
        MainCategory mainCategory = mainCategoryRepository.findByCategoryName(mainCategoryName)
                .orElseThrow(() -> new IllegalArgumentException("해당 카테고리가 존재하지 않습니다."));
        return MainCategoryResponseDto.builder()
                .mainCategoryOrder(mainCategory.getMainCategoryOrder())
                .mainCategoryName(mainCategory.getMainCategoryName())
                .build();
    }

    @Override
    public SubCategoryResponseDto findSubCategoryById(Integer subCategoryId) {
        SubCategory subCategory = subCategoryRepository.findById(subCategoryId).orElseThrow(
                () -> new IllegalArgumentException("해당 카테고리가 존재하지 않습니다.")
        );
        return SubCategoryResponseDto.builder()
                .subCategoryName(subCategory.getSubCategoryName())
                .subCategoryOrder(subCategory.getSubCategoryOrder())
                .build();
    }

    @Override
    public SubCategoryResponseDto findSubCategoryByName(String subCategoryName) {
        SubCategory subCategory = subCategoryRepository.findByCategoryName(subCategoryName)
                .orElseThrow(() -> new IllegalArgumentException("해당 카테고리가 존재하지 않습니다."));
        return SubCategoryResponseDto.builder()
                .subCategoryName(subCategory.getSubCategoryName())
                .subCategoryOrder(subCategory.getSubCategoryOrder())
                .build();
    }

    @Override
    public List<MainCategoryResponseDto> findMainCategories() {
        List<MainCategory> mainCategories = mainCategoryRepository.findAll();

        return mainCategories.stream()
                .map(mainCategory -> MainCategoryResponseDto.builder()
                        .mainCategoryName(mainCategory.getMainCategoryName())
                        .mainCategoryOrder(mainCategory.getMainCategoryOrder())
                        .build())
                .toList();
    }

    @Override
    public List<SubCategoryResponseDto> findSubCategories() {
        List<SubCategory> subCategories = subCategoryRepository.findAll();
        return subCategories.stream()
                .map(subCategory -> SubCategoryResponseDto.builder()
                        .subCategoryOrder(subCategory.getSubCategoryOrder())
                        .subCategoryName(subCategory.getSubCategoryName())
                        .build())
                .toList();
    }

}
