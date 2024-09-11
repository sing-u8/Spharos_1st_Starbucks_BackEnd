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
    private String TopCategoryCode;

    public static MiddleCategoryRequestDto toDto(MiddleCategoryRequestVo MiddleCategoryRequestVo) {

        return MiddleCategoryRequestDto.builder()
                .name(MiddleCategoryRequestVo.getName())
                .sequence(MiddleCategoryRequestVo.getSequence())
                .TopCategoryCode(MiddleCategoryRequestVo.getTopCategoryCode())
                .build();
    }

    public MiddleCategory toEntity(TopCategory TopCategory, String code) {

        return MiddleCategory.builder()
                .name(name)
                .sequence(sequence)
                .TopCategory(TopCategory)
                .code(code)
                .build();
    }

}