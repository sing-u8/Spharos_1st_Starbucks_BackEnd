package TRaMis8khae.starbucks.product.domain;

import jakarta.persistence.*;
import org.w3c.dom.Text;

@Entity
public class ProductInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long productInfoId;
    private Text productInfo;
    @Column(length = 20)
    private String productInfoType;
}
