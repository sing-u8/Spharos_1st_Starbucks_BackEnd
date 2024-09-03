package TRaMis8khae.starbucks.order.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class StarbucksCardInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long StarbucksCardId;
    @Column(nullable = false, length = 50)
    private String StarbucksCardName;
    @Column(columnDefinition = "binary(16)")
    private UUID memberUuid;
}
