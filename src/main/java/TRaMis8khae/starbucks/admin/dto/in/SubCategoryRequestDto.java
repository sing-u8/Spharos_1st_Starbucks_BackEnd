package TRaMis8khae.starbucks.admin.dto.in;

import TRaMis8khae.starbucks.admin.entity.MainCategory;
import TRaMis8khae.starbucks.admin.entity.SubCategory;
import TRaMis8khae.starbucks.admin.vo.SubCategoryRequestVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubCategoryRequestDto {

    private String name;
    private Integer sequence;
    private String mainCategoryCode;
    private String description;

    public static SubCategoryRequestDto toDto(SubCategoryRequestVo subCategoryRequestVo) {

        return SubCategoryRequestDto.builder()
                .name(subCategoryRequestVo.getName())
                .sequence(subCategoryRequestVo.getSequence())
//                .description(subCategoryRequestVo.getDescription())
                .mainCategoryCode(subCategoryRequestVo.getMainCategoryCode())
                .build();
    }

    public SubCategory toEntity(MainCategory mainCategory, String code) {

        return SubCategory.builder()
                .name(name)
                .sequence(sequence)
                .mainCategory(mainCategory)
//                .description(description)
                .code(code)
                .build();
    }

}