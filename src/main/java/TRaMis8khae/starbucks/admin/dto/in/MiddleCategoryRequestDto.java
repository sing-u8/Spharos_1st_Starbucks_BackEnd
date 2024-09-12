package TRaMis8khae.starbucks.admin.dto.in;

import TRaMis8khae.starbucks.admin.entity.TopCategory;
import TRaMis8khae.starbucks.admin.entity.MiddleCategory;
import TRaMis8khae.starbucks.admin.vo.MiddleCategoryRequestVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MiddleCategoryRequestDto {

    private String name;
    private Integer sequence;
    private String topCategoryCode;

    public static MiddleCategoryRequestDto toDto(MiddleCategoryRequestVo middleCategoryRequestVo) {

        return MiddleCategoryRequestDto.builder()
                .name(middleCategoryRequestVo.getName())
                .sequence(middleCategoryRequestVo.getSequence())
                .topCategoryCode(middleCategoryRequestVo.getTopCategoryCode())
                .build();
    }

    public MiddleCategory toEntity(TopCategory topCategory, String code) {

        return MiddleCategory.builder()
                .name(name)
                .sequence(sequence)
                .topCategory(topCategory)
                .code(code)
                .build();
    }

}