package TRaMis8khae.starbucks.order.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class MobileVoucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mobileGiftId;
    @Column(length = 50)
    private String VoucherName;
    private LocalDate endDate;
}
