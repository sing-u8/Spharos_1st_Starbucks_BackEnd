package TRaMis8khae.starbucks.product.domain;

import jakarta.persistence.*;

@Entity
public class MainCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mainCategoryId;
    @Column(nullable = false, length = 50)
    private String mainCategoryName;
    private Integer mainCategoryOrder;
}
