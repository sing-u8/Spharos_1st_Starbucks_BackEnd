package TRaMis8khae.starbucks.product.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.w3c.dom.Text;

import java.time.LocalDateTime;

@Entity
public class Event {
    @Id
    private Long eventId;
    @Column(nullable = false, length = 50)
    private String eventName;
    private Integer discountRate;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Text eventInfoPath;
    private String eventInfoType;


}
