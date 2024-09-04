package TRaMis8khae.starbucks.order.entity;

import jakarta.persistence.*;

@Entity
public class StarbucksCardInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String StarbucksCardName;
    @Column(columnDefinition = "binary(16)")
    private String memberUUID;
}
