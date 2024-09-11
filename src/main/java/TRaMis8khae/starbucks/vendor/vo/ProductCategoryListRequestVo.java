package TRaMis8khae.starbucks.vendor.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategoryListRequestVo {

    private String topCode;

    private String middleCode;

    private String bottomCode;

    private String productUUID;

}