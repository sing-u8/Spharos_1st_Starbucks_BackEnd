package TRaMis8khae.starbucks.order.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class StarbucksCardInfo {
    @Id
    private Long StarbucksCardId;
    @Column(nullable = false, length = 50)
    private String StarbucksCardName;
    @Column(columnDefinition = "binary(16)")
    private UUID memberUuid;
}
