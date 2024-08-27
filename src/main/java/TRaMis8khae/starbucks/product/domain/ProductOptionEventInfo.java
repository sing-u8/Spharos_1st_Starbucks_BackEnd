package TRaMis8khae.starbucks.product.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class ProductOptionEventInfo {
    @Id
    private Long eventInfoListId;
    private Integer infoOrder;
    private String infoType;

    @ManyToOne
    private Product product;
    @ManyToOne
    private Event eventId;
}
