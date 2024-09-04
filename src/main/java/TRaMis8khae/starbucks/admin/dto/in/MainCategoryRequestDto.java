package TRaMis8khae.starbucks.admin.dto.in;

import TRaMis8khae.starbucks.admin.entity.MainCategory;
import TRaMis8khae.starbucks.admin.vo.MainCategoryRequestVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class MainCategoryRequestDto {
    private String mainCategoryName;
    private Integer mainCategoryOrder;//순서

    public static MainCategoryRequestDto toDto(MainCategoryRequestVo mainCategoryRequestVo) {
        return MainCategoryRequestDto.builder()
                .mainCategoryName(mainCategoryRequestVo.getMainCategoryName())
                .mainCategoryOrder(mainCategoryRequestVo.getMainCategoryOrder())
                .build();
    }

    public MainCategory toEntity() {
        return MainCategory.builder()
                .mainCategoryName(mainCategoryName)
                .mainCategoryOrder(mainCategoryOrder)
                .build();
    }


}
