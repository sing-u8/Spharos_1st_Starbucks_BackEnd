package TRaMis8khae.starbucks.product.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    @Column(nullable = false, length = 50)
    private String productName;
    private LocalDate date;
    @Column(columnDefinition = "binary(16)")
    private UUID productUuid;
    private Integer productScore;
}
