package TRaMis8khae.starbucks.order.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class MobileVoucher {
    @Id
    private Long mobileGiftId;
    @Column(length = 50)
    private String VoucherName;
    private LocalDate endDate;
}
