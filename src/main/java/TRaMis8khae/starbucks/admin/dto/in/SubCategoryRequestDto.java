package TRaMis8khae.starbucks.admin.dto.in;

import TRaMis8khae.starbucks.admin.entity.MainCategory;
import TRaMis8khae.starbucks.admin.entity.SubCategory;
import TRaMis8khae.starbucks.admin.vo.SubCategoryRequestVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class SubCategoryRequestDto {
    private String subCategoryName;
    private Integer subCategoryOrder;//순서
    private Integer mainCategoryId;

    public static SubCategoryRequestDto toDto(SubCategoryRequestVo subCategoryRequestVo) {
        return SubCategoryRequestDto.builder()
                .subCategoryName(subCategoryRequestVo.getSubCategoryName())
                .subCategoryOrder(subCategoryRequestVo.getSubCategoryOrder())
                .mainCategoryId(subCategoryRequestVo.getMainCategoryId())
                .build();
    }

    public SubCategory toEntity(MainCategory mainCategory) {
        return SubCategory.builder()
                .subCategoryName(subCategoryName)
                .subCategoryOrder(subCategoryOrder)
                .mainCategory(mainCategory)
                .build();
    }

}
