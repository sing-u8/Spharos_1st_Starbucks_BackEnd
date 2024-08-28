package TRaMis8khae.starbucks.product.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class AdditionalProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
