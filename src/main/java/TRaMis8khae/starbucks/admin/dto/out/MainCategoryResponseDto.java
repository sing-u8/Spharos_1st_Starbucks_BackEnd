package TRaMis8khae.starbucks.admin.dto.out;

import TRaMis8khae.starbucks.admin.entity.MainCategory;
import TRaMis8khae.starbucks.admin.vo.MainCategoryResponseVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MainCategoryResponseDto {

    private String mainCategoryName;
    private Integer mainCategorySeq;

    public static MainCategoryResponseDto toDto(MainCategory mainCategory) {
        return MainCategoryResponseDto.builder()
                .mainCategoryName(mainCategory.getMainCategoryName())
                .mainCategorySeq(mainCategory.getMainCategorySeq())
                .build();
    }

    public MainCategoryResponseVo toVo() {
        return MainCategoryResponseVo.builder()
                .mainCategoryPurchase(mainCategorySeq)
                .mainCategoryName(mainCategoryName)
                .build();
    }

}