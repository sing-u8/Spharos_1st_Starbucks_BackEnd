package TRaMis8khae.starbucks.vendor.entity;

import TRaMis8khae.starbucks.product.entity.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategoryList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String middleCode;

    @Column(length = 50)
    private String topCode;

    @Column(length = 50)
    private String bottomCode;

    private String productUUID;

}