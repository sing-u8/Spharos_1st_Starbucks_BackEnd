package TRaMis8khae.starbucks.product.vo;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ProductRequestVo {

    private String productName;

    private Double price;

    private String description;

    private Boolean additionalChecked;

}