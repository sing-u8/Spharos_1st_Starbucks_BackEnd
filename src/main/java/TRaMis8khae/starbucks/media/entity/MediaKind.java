package TRaMis8khae.starbucks.media.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MediaKind {

    PRODUCT("상품"),
    EVENT("이벤트"),
    REVIEW("리뷰"),;

    private final String mediaKind;

    @JsonValue
    public String getMediaKind() {
        return mediaKind;
    }

    @JsonCreator
    public static MediaKind fromString(String value) {
        for (MediaKind mediaKind: MediaKind.values()) {
            if (mediaKind.mediaKind.equals(value)) {
                return mediaKind;
            }
        }
        throw new IllegalArgumentException("UnKnown value: " + value);
    }

}
