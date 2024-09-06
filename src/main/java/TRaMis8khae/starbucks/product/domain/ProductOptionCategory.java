package TRaMis8khae.starbucks.product.domain;

import jakarta.persistence.*;

@Entity
public class ProductOptionCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productCategoryId;
    private Long subCategoryId;
    private Long mainCategoryId;

    @ManyToOne
    private Product product;
}
