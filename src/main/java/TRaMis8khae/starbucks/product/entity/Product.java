package TRaMis8khae.starbucks.product.entity;

import TRaMis8khae.starbucks.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String productName;

    private String productUUID;

    private Integer productScore;

    private Double price;

    private String description;

    private Boolean additionalChecked;
    
}