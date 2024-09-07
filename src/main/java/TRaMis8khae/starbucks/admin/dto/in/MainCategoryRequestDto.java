package TRaMis8khae.starbucks.admin.dto.in;

import TRaMis8khae.starbucks.admin.entity.MainCategory;
import TRaMis8khae.starbucks.admin.vo.MainCategoryRequestVo;
import lombok.Getter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MainCategoryRequestDto {

    private String mainCategoryName;
    private Integer mainCategorySeq;//순서

    public static MainCategoryRequestDto toDto(MainCategoryRequestVo mainCategoryRequestVo) {
        return MainCategoryRequestDto.builder()
                .mainCategoryName(mainCategoryRequestVo.getMainCategoryName())
                .mainCategorySeq(mainCategoryRequestVo.getMainCategorySeq())
                .build();
    }

    public MainCategory toEntity() {
        return MainCategory.builder()
                .mainCategoryName(mainCategoryName)
                .mainCategorySeq(mainCategorySeq)
                .build();
    }

}