package TRaMis8khae.starbucks.admin.dto.out;

import TRaMis8khae.starbucks.admin.entity.SubCategory;
import TRaMis8khae.starbucks.admin.vo.SubCategoryResponseVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubCategoryResponseDto {

    private String name;
    private String code;
//    private String description;

    public static SubCategoryResponseDto toDto(SubCategory subCategory) {
        return SubCategoryResponseDto.builder()
                .name(subCategory.getName())
                .code(subCategory.getCode())
//                .description(subCategory.getDescription())
                .build();
    }

    public SubCategoryResponseVo toVo() {
        return SubCategoryResponseVo.builder()
                .code(code)
                .name(name)
//                .description(description)
                .build();
    }

}