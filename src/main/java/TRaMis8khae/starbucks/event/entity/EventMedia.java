package TRaMis8khae.starbucks.event.entity;

import TRaMis8khae.starbucks.media.entity.Media;
import TRaMis8khae.starbucks.media.entity.MediaKind;
import TRaMis8khae.starbucks.media.entity.MediaType;
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

    private String eventMediaName;

    private String eventMediaPath;

}
