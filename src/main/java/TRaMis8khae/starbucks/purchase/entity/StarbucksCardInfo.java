package TRaMis8khae.starbucks.purchase.entity;

import jakarta.persistence.*;
// member로
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
