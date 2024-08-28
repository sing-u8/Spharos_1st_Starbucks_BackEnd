package TRaMis8khae.starbucks.product.domain;

import jakarta.persistence.*;
import org.w3c.dom.Text;

@Entity
public class ProductInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productInfoId;
    @Column(columnDefinition = "text")
    private String productInfo;
    @Column(length = 20)
    private String productInfoType;
}
