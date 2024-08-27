package TRaMis8khae.starbucks;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Wish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wishId;
    @Column(columnDefinition = "binary(16)")
    private UUID memberUuid;
    @Column(columnDefinition = "binary(16)")
    private UUID productUuid;
    private Boolean wishChecked;
}
