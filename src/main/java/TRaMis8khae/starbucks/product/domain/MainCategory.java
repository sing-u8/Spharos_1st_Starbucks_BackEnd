package TRaMis8khae.starbucks.product.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class MainCategory {
    @Id
    private Long mainCategoryId;
    @Column(nullable = false, length = 50)
    private String mainCategoryName;
    private Integer mainCategoryOrder;
}
