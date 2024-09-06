package TRaMis8khae.starbucks.product.domain;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

@Entity
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer subCategoryId;
    @Column(nullable = false, length = 50)
    private String subCategoryName;
    private Integer subCategoryOrder;

    @ManyToOne
    private MainCategory mainCategory;
}
