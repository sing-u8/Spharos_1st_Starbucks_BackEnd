package TRaMis8khae.starbucks.event.entity;

import TRaMis8khae.starbucks.common.entity.Media;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class EventMedia extends Media {

    @Id
    private Long id;

    private Boolean thumbChecked;

    @Builder
    public EventMedia(
            String path, Boolean thumbChecked,
            Boolean mainChecked, Boolean detailChecked,
            Boolean eventChecked, Long id) {

        super(path, thumbChecked, mainChecked, detailChecked, eventChecked);
        this.id = id;
    }

}
