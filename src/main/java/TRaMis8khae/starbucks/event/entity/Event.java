package TRaMis8khae.starbucks.event.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String eventName;

    private Integer discountRate;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

}
