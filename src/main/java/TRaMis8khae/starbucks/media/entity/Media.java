package TRaMis8khae.starbucks.media.entity;

import TRaMis8khae.starbucks.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Media extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String mediaUrl;

    private Boolean thumbChecked;

    private MediaType mediaType;

    private MediaKind mediaKind;

    private Integer mediaSeq;

    @Builder
    public Media(String mediaUrl, Boolean thumbChecked, MediaType mediaType, MediaKind mediaKind, Integer mediaSeq) {
        this.mediaUrl = mediaUrl;
        this.thumbChecked = thumbChecked;
        this.mediaType = mediaType;
        this.mediaKind = mediaKind;
        this.mediaSeq = mediaSeq;
    }
}