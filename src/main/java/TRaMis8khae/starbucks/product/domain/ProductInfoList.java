package TRaMis8khae.starbucks.product.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ProductInfoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productInfoId;
    @Column(columnDefinition = "binary(16)")
    private UUID productUuid;
    private Integer imageOrder;
    @Column(length = 20)
    private String imageType;

    @ManyToOne
    private ProductInfo productInfo;
}
