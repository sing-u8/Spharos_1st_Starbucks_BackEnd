package TRaMis8khae.starbucks.product.entity;

import TRaMis8khae.starbucks.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String productName;

    @Column(nullable = false, length = 50)
    private String productUUID;

    private Double productScore = 0.0;

    @Column(nullable = false)
    private Double price;

    private String description;

    private Boolean additionalChecked;

    private Boolean isAdditionalTogether;

    private Boolean engravingChecked;

    @Column(nullable = false)
    private Integer maxOrderCount;

    @Column(nullable = false)
    private Integer minOrderCount = 1;

    @Column(nullable = false)
    private Long mediaId;
    
}