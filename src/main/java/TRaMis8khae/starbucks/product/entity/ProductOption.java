package TRaMis8khae.starbucks.product.entity;

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
public class ProductOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String productUUID;

    @Column(nullable = false, length = 30)
    private String productName;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Integer stockQuantity;

    @Column(nullable = false)
    private Integer limitCnt;

    private Boolean soldOutChecked;

    private Boolean closedChecked;

    private Boolean openChecked;

    @ManyToOne(fetch = FetchType.LAZY)
    private Volume volume;

    @ManyToOne(fetch = FetchType.LAZY)
    private Color color;

}