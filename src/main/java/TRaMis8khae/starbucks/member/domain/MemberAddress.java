package TRaMis8khae.starbucks.member.domain;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class MemberAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberAddressId;
    @Column(columnDefinition = "binary(16)")
    private UUID memberUuid;
    private Boolean addressDefaultCheck;

    @ManyToOne
    private DeliveryAddress deliveryAddress;
}
