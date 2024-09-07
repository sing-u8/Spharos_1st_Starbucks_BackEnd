package TRaMis8khae.starbucks.product.entity;

import jakarta.persistence.*;

@Entity
public class Engraving {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    private Boolean checked;

}