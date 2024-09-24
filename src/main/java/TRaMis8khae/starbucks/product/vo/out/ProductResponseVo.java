package TRaMis8khae.starbucks.product.vo.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Builder
public class ProductResponseVo {

    private String productName;

    private String productUUID;

    private Double price;

}