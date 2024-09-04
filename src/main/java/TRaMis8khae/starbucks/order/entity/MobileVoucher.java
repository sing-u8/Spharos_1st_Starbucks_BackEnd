package TRaMis8khae.starbucks.order.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class MobileVoucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String VoucherName;
    private LocalDate endDate;
}
