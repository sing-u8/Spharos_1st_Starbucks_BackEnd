package TRaMis8khae.starbucks.admin.dto.in;

import TRaMis8khae.starbucks.admin.entity.MainCategory;
import lombok.Getter;

@Getter
public class MainCategoryRequestDto {
    private String mainCategoryName;
    private Integer mainCategoryOrder;//순서

    public MainCategory toEntity() {
        return MainCategory.builder()
                .mainCategoryName(mainCategoryName)
                .mainCategoryOrder(mainCategoryOrder)
                .build();
    }


}
