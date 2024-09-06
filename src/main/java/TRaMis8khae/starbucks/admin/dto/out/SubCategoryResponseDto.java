package TRaMis8khae.starbucks.admin.dto.out;

import TRaMis8khae.starbucks.admin.dto.in.SubCategoryRequestDto;
import TRaMis8khae.starbucks.admin.entity.MainCategory;
import TRaMis8khae.starbucks.admin.entity.SubCategory;
import TRaMis8khae.starbucks.admin.vo.SubCategoryResponseVo;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubCategoryResponseDto {
    private String subCategoryName;
    private Integer subCategoryOrder;
    private Integer mainCategoryId;

    public static SubCategoryResponseDto toDto(SubCategory subCategory) {
        return SubCategoryResponseDto.builder()
                .subCategoryName(subCategory.getSubCategoryName())
                .subCategoryOrder(subCategory.getSubCategoryOrder())
                .mainCategoryId(subCategory.getMainCategory().getId())
                .build();
    }

    public SubCategoryResponseVo toVo() {
        return SubCategoryResponseVo.builder()
                .subCategoryName(subCategoryName)
                .subCategoryOrder(subCategoryOrder)
                .build();
    }

}
