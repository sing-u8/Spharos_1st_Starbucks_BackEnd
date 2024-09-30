package TRaMis8khae.starbucks.admin.dto.in;

import TRaMis8khae.starbucks.admin.entity.TopCategory;
import TRaMis8khae.starbucks.admin.vo.TopCategoryRequestVo;
import lombok.Getter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TopCategoryRequestDto {

    private String name;
    private Integer sequence;

    public static TopCategoryRequestDto toDto(TopCategoryRequestVo TopCategoryRequestVo) {
        return TopCategoryRequestDto.builder()
                .name(TopCategoryRequestVo.getName())
                .sequence(TopCategoryRequestVo.getSequence())
                .build();
    }

    public TopCategory toEntity(String code) {
        return TopCategory.builder()
                .name(name)
                .sequence(sequence)
                .code(code)
                .build();
    }

}