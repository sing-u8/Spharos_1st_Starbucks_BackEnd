package TRaMis8khae.starbucks.product.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Product {
    @Id
    private Long productId;
    @Column(nullable = false, length = 50)
    private String productName;
    private LocalDate date;
    @Column(columnDefinition = "binary(16)")
    private UUID productUuid;
    private Integer productScore;
}
