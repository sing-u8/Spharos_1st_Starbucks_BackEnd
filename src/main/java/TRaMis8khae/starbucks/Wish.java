package TRaMis8khae.starbucks;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Wish {
    @Id
    private Long wishId;
    @Column(columnDefinition = "binary(16)")
    private UUID memberUuid;
    @Column(columnDefinition = "binary(16)")
    private UUID productUuid;
    private Boolean wishChecked;
}
