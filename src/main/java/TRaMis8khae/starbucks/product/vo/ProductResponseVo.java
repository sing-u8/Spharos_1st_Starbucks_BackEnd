package TRaMis8khae.starbucks.product.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseVo {

    private String productName;

    private String productUUID;

    private Double price;

    private Long optionId;

    private Boolean soldOutChecked;

    private Boolean closedChecked;

    private Boolean openChecked;

    private Boolean thumbChecked;

    private String path;

}