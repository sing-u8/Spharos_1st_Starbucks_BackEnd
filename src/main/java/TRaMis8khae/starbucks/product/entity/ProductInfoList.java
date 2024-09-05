package TRaMis8khae.starbucks.product.entity;

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
public class ProductInfoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productUUID;
    private Integer imageOrder;
    @Column(length = 20)
    private String imageType;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProductInfo productInfo;
}
