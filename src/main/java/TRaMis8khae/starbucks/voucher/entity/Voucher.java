package TRaMis8khae.starbucks.voucher.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
// member로
@Entity
public class Voucher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String name;

    private LocalDate endDate;

    // 양방향 연관 관계를 끊는다
//    private List<MemberVoucherList> memberVoucherList = new ArrayList<>();
}
