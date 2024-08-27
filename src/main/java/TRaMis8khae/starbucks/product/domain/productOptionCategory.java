package TRaMis8khae.starbucks.product.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class productOptionCategory {
    @Id
    private Long productCategoryId;
    private Long subCategoryId;
    private Long mainCategoryId;

    @ManyToOne
    private Product product;
}
