package TRaMis8khae.starbucks.product.entity;

import jakarta.persistence.*;

@Entity
public class ProductEventInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer infoOrder;
    private String infoType;

    @ManyToOne
    private Product product;
    @ManyToOne
    private Event eventId;
}
