package TRaMis8khae.starbucks.product.entity;

import jakarta.persistence.*;

@Entity
public class ProductCategoryList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Long subCategoryId;
    private Long mainCategoryId;

    @ManyToOne
    private Product product;
}
