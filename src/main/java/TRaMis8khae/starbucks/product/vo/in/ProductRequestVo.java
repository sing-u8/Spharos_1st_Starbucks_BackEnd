package TRaMis8khae.starbucks.product.vo.in;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
public class ProductRequestVo {

    private String productName;

    private Double price;

    private String description;

    private Boolean additionalChecked;

    private Boolean isAdditionalTogether;

    private Boolean engravingChecked;

    private Integer maxOrderCount;

    private Integer minOrderCount;

    private List<Long> mediaIds;

}