package TRaMis8khae.starbucks.product.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class AdditionalProduct {
    @Id
    private Long additionalProductId;
    @Column(columnDefinition = "binary(16)")
    private UUID productUuid;
    @Column(nullable = false, length = 50)
    private String productName;
    private Integer price;
    @Column(nullable = false, length = 50)
    private LocalDate registerDate;
    private Integer limitedCount;
    private Integer stockQuantity;


}
