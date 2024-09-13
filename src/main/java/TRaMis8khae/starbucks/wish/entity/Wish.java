package TRaMis8khae.starbucks.wish.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Wish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String memberUUID;

    private String productUUID;

    private Boolean wishChecked;

    @Builder
    public Wish(Long id, String memberUUID, String productUUID, Boolean wishChecked) {
        this.id = id;
        this.memberUUID = memberUUID;
        this.productUUID = productUUID;
        this.wishChecked = wishChecked;
    }
}