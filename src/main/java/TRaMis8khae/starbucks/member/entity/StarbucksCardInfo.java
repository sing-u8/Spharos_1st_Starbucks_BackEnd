package TRaMis8khae.starbucks.member.entity;

import jakarta.persistence.*;

@Entity
public class StarbucksCardInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String StarbucksCardName;

    @Column(length = 36)
    private String memberUUID;

}