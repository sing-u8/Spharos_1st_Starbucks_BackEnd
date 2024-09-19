package TRaMis8khae.starbucks.media.application;

import TRaMis8khae.starbucks.media.dto.MediaAddRequestDto;
import TRaMis8khae.starbucks.media.dto.MediaAddResponseDto;

public interface MediaService {

    MediaAddResponseDto addMedia(MediaAddRequestDto mediaAddRequestDto);

    MediaAddResponseDto getMedia(Long mediaId);

    void deleteMedia(Long mediaId);

}