package TRaMis8khae.starbucks.product.entity;

import TRaMis8khae.starbucks.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    private Double productScore;

    @Column(nullable = false)
    private Double price;

    private String description;

    private Boolean additionalChecked;

    private Boolean isAdditionalTogether;

    private Boolean engravingChecked;

    @Column(nullable = false)
    private Integer maxOrderCount;

    private Integer minOrderCount;

}