package TRaMis8khae.starbucks.product.vo;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class ProductRequestVo {

    private String productName;

    private Double price;

    private String description;

    private Boolean additionalChecked;

    private Boolean isAdditionalTogether;

    private Boolean engravingChecked;

    private String volumeName;

    private Integer maxOrderCount;

    private Integer minOrderCount;

    private Long mediaId;

}