package TRaMis8khae.starbucks.media.application;

import TRaMis8khae.starbucks.common.entity.BaseResponseStatus;
import TRaMis8khae.starbucks.common.exception.BaseException;
import TRaMis8khae.starbucks.media.dto.MediaAddRequestDto;
import TRaMis8khae.starbucks.media.dto.MediaAddResponseDto;
import TRaMis8khae.starbucks.media.infrastructure.MediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MediaServiceImpl implements MediaService{

    private final MediaRepository mediaRepository;

    @Override
    public MediaAddResponseDto addMedia(MediaAddRequestDto mediaAddRequestDto) {
        return MediaAddResponseDto.toDto(mediaRepository.save(mediaAddRequestDto.toEntity()));
    }

    @Override
    public MediaAddResponseDto getMedia(Long mediaId) {
        return MediaAddResponseDto.toDto(mediaRepository.findById(mediaId)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_MEDIA)));
    }

    @Override
    public void deleteMedia(Long mediaId) {
        mediaRepository.deleteById(mediaId);
    }

}