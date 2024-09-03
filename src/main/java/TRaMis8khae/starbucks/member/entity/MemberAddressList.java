package TRaMis8khae.starbucks.member.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class MemberAddressList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberAddressId;
    @Column(length = 36)
    private String memberUUID;
    private Boolean addressDefaultCheck;

    @ManyToOne
    @JoinColumn(name = "deliveryAddressId")
    private DeliveryAddress deliveryAddress;
}
