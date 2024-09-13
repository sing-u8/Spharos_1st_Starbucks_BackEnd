package TRaMis8khae.starbucks.cashreceipt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CashReceipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cashReceiptId;

    private Boolean checked;//현금영수증 발행여부

    private String memberUuid;

}