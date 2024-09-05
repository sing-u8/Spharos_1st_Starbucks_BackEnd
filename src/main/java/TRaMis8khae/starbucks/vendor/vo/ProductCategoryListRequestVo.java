package TRaMis8khae.starbucks.vendor.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategoryListRequestVo {
    private Integer subCategoryId;
    private Integer mainCategoryId;
    private Long productId;

}
