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

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    public EventMedia(
            String mediaUrl, Boolean thumbChecked, MediaType mediaType,
            MediaKind mediaKind, Integer mediaSeq, Event event) {

        super(mediaUrl, thumbChecked, mediaType, mediaKind, mediaSeq);  // 상위 클래스 Media의 필드를 초기화
        this.event = event;  // Event와의 관계 설정
    }


}
