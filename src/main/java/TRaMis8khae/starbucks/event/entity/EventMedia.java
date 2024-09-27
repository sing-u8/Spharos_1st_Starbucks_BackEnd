package TRaMis8khae.starbucks.event.entity;

import TRaMis8khae.starbucks.media.entity.Media;
import TRaMis8khae.starbucks.media.entity.MediaKind;
import TRaMis8khae.starbucks.media.entity.MediaType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EventMedia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long eventId;

    private Long mediaId;

    private Long productId;

    @Builder
    public EventMedia(Long eventId, Long mediaId, Long productId) {
        this.eventId = eventId;
        this.mediaId = mediaId;
        this.productId = productId;
    }
}
