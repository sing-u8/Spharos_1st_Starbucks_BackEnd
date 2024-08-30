package TRaMis8khae.starbucks.product.vo;

import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
public class ProductRequestVo {
    private String productName;
    private LocalDate date;
}
