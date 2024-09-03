package TRaMis8khae.starbucks.product.entity;

import jakarta.persistence.*;

@Entity
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subCategoryId;
    @Column(nullable = false, length = 50)
    private String subCategoryName;
    private Integer subCategoryOrder;

    @ManyToOne
    private MainCategory mainCategory;
}
