package TRaMis8khae.starbucks;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class CashReceipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cashReceiptId;
    private Boolean checked;//현금영수증 발행여부
    @Column(columnDefinition = "binary(16)")
    private UUID memberUuid;
}
