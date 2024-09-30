package TRaMis8khae.starbucks.event.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@ToString
@NoArgsConstructor
@Where(clause = "is_deleted = false")
@SQLDelete(sql = "UPDATE event SET is_deleted = true WHERE id = ?")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String eventName;

    private Integer discountRate;

    private LocalDate startDate;

    private LocalDate endDate;

    private Boolean isDeleted = false;

    @Builder
    public Event(String eventName, Integer discountRate, LocalDate startDate, LocalDate endDate) {
        this.eventName = eventName;
        this.discountRate = discountRate;
        this.startDate = startDate;
        this.endDate = endDate;
    }

}