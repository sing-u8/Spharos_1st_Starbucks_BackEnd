package TRaMis8khae.starbucks.event.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String eventName;

    private Integer discountRate;

    private LocalDate startDate;

    private LocalDate endDate;

    @Builder
    public Event(String eventName, Integer discountRate, LocalDate startDate, LocalDate endDate) {
        this.eventName = eventName;
        this.discountRate = discountRate;
        this.startDate = startDate;
        this.endDate = endDate;
    }


}