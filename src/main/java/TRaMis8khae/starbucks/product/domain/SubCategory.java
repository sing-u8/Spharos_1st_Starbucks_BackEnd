package TRaMis8khae.starbucks.product.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class SubCategory {
    @Id
    private Long subCategoryId;
    @Column(nullable = false, length = 50)
    private String subCategoryName;
    private Integer subCategoryOrder;

    @ManyToOne
    private MainCategory mainCategory;
}
