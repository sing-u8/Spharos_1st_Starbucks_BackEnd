package TRaMis8khae.starbucks.media.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MediaType {

    IMAGE("사진"),
    VIDEO("동영상");

    private final String mediaType;

    @JsonValue
    public String getMediaType() {
        return mediaType;
    }

    @JsonCreator
    public static MediaType fromString(String value) {
        for (MediaType mediaType: MediaType.values()) {
            if (mediaType.mediaType.equals(value)) {
                return mediaType;
            }
        }
        throw new IllegalArgumentException("UnKnown value: " + value);
    }

}
