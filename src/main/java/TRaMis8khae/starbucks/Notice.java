package TRaMis8khae.starbucks;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Notice {
    @Id
    private Long noticeId;
    private LocalDateTime noticeTime;
    @Column(nullable = false, length = 50)
    private String noticeMessage;
    private Long memberId;
    private String noticeIcon;
    private Long targetId;
}
