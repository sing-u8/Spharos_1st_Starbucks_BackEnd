package TRaMis8khae.starbucks.product.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ProductInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productInfoId;
    @Column(columnDefinition = "text")
    private String productInfo;
    @Column(length = 20)
    private String productInfoType;
}
