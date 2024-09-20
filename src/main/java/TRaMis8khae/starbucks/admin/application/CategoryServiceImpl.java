package TRaMis8khae.starbucks.admin.application;

import TRaMis8khae.starbucks.admin.dto.in.BottomCategoryRequestDto;
import TRaMis8khae.starbucks.admin.dto.in.TopCategoryRequestDto;
import TRaMis8khae.starbucks.admin.dto.in.MiddleCategoryRequestDto;
import TRaMis8khae.starbucks.admin.dto.out.BottomCategoryResponseDto;
import TRaMis8khae.starbucks.admin.dto.out.TopCategoryResponseDto;
import TRaMis8khae.starbucks.admin.dto.out.MiddleCategoryResponseDto;
import TRaMis8khae.starbucks.admin.entity.BottomCategory;
import TRaMis8khae.starbucks.admin.entity.TopCategory;
import TRaMis8khae.starbucks.admin.entity.MiddleCategory;
import TRaMis8khae.starbucks.admin.infrastructure.BottomCategoryRepository;
import TRaMis8khae.starbucks.admin.infrastructure.TopCategoryRepository;
import TRaMis8khae.starbucks.admin.infrastructure.MiddleCategoryRepository;
import TRaMis8khae.starbucks.common.utils.CodeGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final TopCategoryRepository topCategoryRepository;
    private final MiddleCategoryRepository middleCategoryRepository;
    private final BottomCategoryRepository bottomCategoryRepository;


    @Override
    public void addTopCategory(TopCategoryRequestDto requestDto) {

        if (topCategoryRepository.existsByName(requestDto.getName())) {
            throw new IllegalArgumentException("해당 카테고리의 이름이 존재합니다.");
        }
        if (topCategoryRepository.existsBySequence(requestDto.getSequence())) {
            throw new IllegalArgumentException("순서가 존재합니다. ");
        }

        topCategoryRepository.save(requestDto.toEntity(
            CodeGenerator.generateCode(8)));
    }


    @Override
    public void addMiddleCategory(MiddleCategoryRequestDto requestDto) {

        TopCategory topCategory = topCategoryRepository.findByCode(requestDto.getTopCategoryCode())
                    .orElseThrow(
                        () -> new IllegalArgumentException("해당 top 카테고리가 존재하지 않습니다.")
                    );

        middleCategoryRepository.save(requestDto.toEntity(
            topCategory, CodeGenerator.generateCode(8)));
    }


    @Override
    public void addBottomCategory(BottomCategoryRequestDto requestDto) {

        MiddleCategory middleCategory = middleCategoryRepository.findByCode(requestDto.getMiddleCategoryCode())
            .orElseThrow(
                () -> new IllegalArgumentException("해당 middle 카테고리가 존재하지 않습니다.")
            );

        bottomCategoryRepository.save(requestDto.toEntity(
            middleCategory, CodeGenerator.generateCode(8)));
    }


    @Override
    public TopCategoryResponseDto findTopCategoryByName(String name) {

        TopCategory topCategory = topCategoryRepository.findByName(name).orElseThrow(
            () -> new IllegalArgumentException("해당 bottom 카테고리가 존재하지 않습니다.")
        );

        return TopCategoryResponseDto.toDto(topCategory);
    }


    @Override
    public TopCategoryResponseDto findTopCategoryByCode(String code) {

        TopCategory topCategory = topCategoryRepository.findByCode(code).orElseThrow(
            () -> new IllegalArgumentException("해당 카테고리가 존재하지 않습니다.")
        );

        return TopCategoryResponseDto.toDto(topCategory);
    }



    @Override
    public MiddleCategoryResponseDto findMiddleCategoryByName(String name) {

        MiddleCategory middleCategory = middleCategoryRepository.findByName(name).orElseThrow(
            () -> new IllegalArgumentException("해당 카테고리가 존재하지 않습니다.")
        );

        return MiddleCategoryResponseDto.toDto(middleCategory);
    }


    @Override
    public MiddleCategoryResponseDto findMiddleCategoryByCode(String code) {

        MiddleCategory middleCategory = middleCategoryRepository.findByCode(code).orElseThrow(
            () -> new IllegalArgumentException("해당 카테고리가 존재하지 않습니다.")
        );

        return MiddleCategoryResponseDto.toDto(middleCategory);
    }



    @Override
    public BottomCategoryResponseDto findBottomCategoryByName(String name) {

        BottomCategory bottomCategory = bottomCategoryRepository.findByName(name).orElseThrow(
            () -> new IllegalArgumentException("해당 카테고리가 존재하지 않습니다.")
        );

        return BottomCategoryResponseDto.toDto(bottomCategory);
    }


    @Override
    public BottomCategoryResponseDto findBottomCategoryByCode(String code) {

        BottomCategory bottomCategory = bottomCategoryRepository.findByCode(code).orElseThrow(
            () -> new IllegalArgumentException("해당 카테고리가 존재하지 않습니다.")
        );

        return BottomCategoryResponseDto.toDto(bottomCategory);
    }


    @Override
    public List<TopCategoryResponseDto> findTopCategories() {

        List<TopCategory> topCategories = topCategoryRepository.findAll();

        return topCategories.stream().map(TopCategoryResponseDto::toDto).toList();
    }


    @Override
    public List<MiddleCategoryResponseDto> findMiddleCategories(String topCategoryCode) {

        List<MiddleCategory> middleCategories = middleCategoryRepository.findByTopCategoryCode(topCategoryCode);

        return middleCategories.stream().map(MiddleCategoryResponseDto::toDto).toList();
    }


    @Override
    public List<BottomCategoryResponseDto> findBottomCategories(String middleCategoryCode) {

        List<BottomCategory> bottomCategories = bottomCategoryRepository.findByMiddleCategoryCode(middleCategoryCode);

        return bottomCategories.stream().map(BottomCategoryResponseDto::toDto).toList();
    }

}