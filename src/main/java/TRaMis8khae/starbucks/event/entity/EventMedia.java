package TRaMis8khae.starbucks.event.entity;

import TRaMis8khae.starbucks.common.entity.Media;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class EventMedia extends Media {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @Builder
    public EventMedia(
            String path, Boolean thumbChecked,
            Boolean mainChecked, Boolean detailChecked,
            Boolean eventChecked, Long id) {

        super(path, thumbChecked, mainChecked, detailChecked, eventChecked);
        this.id = id;
    }

}
