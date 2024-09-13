package TRaMis8khae.starbucks.admin.dto.out;

import TRaMis8khae.starbucks.admin.entity.MiddleCategory;
import TRaMis8khae.starbucks.admin.vo.MiddleCategoryResponseVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MiddleCategoryResponseDto {

    private String name;
    private String code;
//    private String description;

    public static MiddleCategoryResponseDto toDto(MiddleCategory MiddleCategory) {
        return MiddleCategoryResponseDto.builder()
                .name(MiddleCategory.getName())
                .code(MiddleCategory.getCode())
//                .description(MiddleCategory.getDescription())
                .build();
    }

    public MiddleCategoryResponseVo toVo() {
        return MiddleCategoryResponseVo.builder()
                .code(code)
                .name(name)
//                .description(description)
                .build();
    }

}