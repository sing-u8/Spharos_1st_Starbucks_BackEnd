package TRaMis8khae.starbucks.admin.dto.out;

import TRaMis8khae.starbucks.admin.entity.TopCategory;
import TRaMis8khae.starbucks.admin.vo.TopCategoryResponseVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TopCategoryResponseDto {

    private String name;
    private Integer sequence;
    private String code;

    public static TopCategoryResponseDto toDto(TopCategory TopCategory) {
        return TopCategoryResponseDto.builder()
                .name(TopCategory.getName())
                .sequence(TopCategory.getSequence())
                .code(TopCategory.getCode())
                .build();
    }

    public TopCategoryResponseVo toVo() {
        return TopCategoryResponseVo.builder()
            .name(name)
            .sequence(sequence)
                .code(code)
                .build();
    }

}