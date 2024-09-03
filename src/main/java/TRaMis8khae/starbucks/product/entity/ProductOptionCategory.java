package TRaMis8khae.starbucks.product.entity;

import jakarta.persistence.*;

@Entity
public class ProductOptionCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productCategoryId;
    private Long subCategoryId;
    private Long mainCategoryId;

    @ManyToOne
    private Product product;
}
