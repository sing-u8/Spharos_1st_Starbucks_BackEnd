package TRaMis8khae.starbucks.notice.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noticeId;

    private LocalDateTime noticeTime;

    @Column(nullable = false, length = 50)
    private String noticeMessage;

    private Long memberId;

    private String noticeIcon;

    private Long targetId;

}