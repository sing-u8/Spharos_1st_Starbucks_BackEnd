package TRaMis8khae.starbucks.product.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;
    @Column(nullable = false, length = 50)
    private String eventName;
    private Integer discountRate;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    @Column(columnDefinition = "text")
    private String eventInfoPath;
    private String eventInfoType;


}
