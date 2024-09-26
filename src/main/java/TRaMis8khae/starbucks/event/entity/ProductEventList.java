package TRaMis8khae.starbucks.event.entity;

import TRaMis8khae.starbucks.product.entity.Product;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class ProductEventList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    private Event event;

    @Builder
    public ProductEventList(Product product, Event event) {
        this.product = product;
        this.event = event;
    }

    public String getProductUUID() {
        return product.getProductUUID();
    }

}