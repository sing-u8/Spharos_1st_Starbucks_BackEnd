package TRaMis8khae.starbucks.admin.dto.in;

import TRaMis8khae.starbucks.admin.entity.MainCategory;
import TRaMis8khae.starbucks.admin.entity.SubCategory;
import lombok.Builder;
import lombok.Getter;

@Getter
public class SubCategoryRequestDto {
    private String subCategoryName;
    private Integer subCategoryOrder;//순서
    private Integer mainCategoryId;

    public SubCategory toEntity(MainCategory mainCategory) {
        return SubCategory.builder()
                .subCategoryName(subCategoryName)
                .subCategoryOrder(subCategoryOrder)
                .mainCategory(mainCategory)
                .build();
    }

    @Builder
    public SubCategoryRequestDto(String subCategoryName, Integer mainCategoryId, Integer subCategoryOrder) {
        this.subCategoryName = subCategoryName;
        this.mainCategoryId = mainCategoryId;
        this.subCategoryOrder = subCategoryOrder;
    }
}
