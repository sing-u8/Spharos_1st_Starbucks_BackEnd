package TRaMis8khae.starbucks.event.entity;

import TRaMis8khae.starbucks.product.entity.Product;
import jakarta.persistence.*;

@Entity
public class ProductEventList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    private Event eventId;

}