package TRaMis8khae.starbucks.media.presentation;

import TRaMis8khae.starbucks.common.entity.BaseResponse;
import TRaMis8khae.starbucks.common.entity.BaseResponseStatus;
import TRaMis8khae.starbucks.media.application.MediaService;
import TRaMis8khae.starbucks.media.dto.MediaAddRequestDto;
import TRaMis8khae.starbucks.media.vo.MediaAddRequestVo;
import TRaMis8khae.starbucks.media.vo.MediaAddResponseVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/media")
public class MediaController {

    /**
     * 미디어 서비스
     * 1. 미디어 추가
     * 2. 미디어 조회
     * 3. 미디어 삭제
     */

    private final MediaService mediaService;

    /**
     * 미디어 추가
     * @param mediaAddRequestVo 미디어 추가 요청
     * @return 미디어 추가 응답
     */
    @Operation(summary = "Add Media API", description = "Add Media API 입니다.", tags = {"Media"})
    @PostMapping
    public BaseResponse<MediaAddResponseVo> addMedia(@RequestBody MediaAddRequestVo mediaAddRequestVo) {
        return new BaseResponse<>(
                mediaService.addMedia(MediaAddRequestDto.toDto(mediaAddRequestVo)).toVo()
        );
    }

    /**
     * 미디어 조회
     * @param mediaId 미디어 ID
     * @return 미디어 조회 응답
     */
    @Operation(summary = "Get Media API", description = "Get Media API 입니다.", tags = {"Media"})
    @GetMapping("/{mediaId}")
    public BaseResponse<MediaAddResponseVo> getMedia(@PathVariable Long mediaId, String reviewUUID) {
        return new BaseResponse<>(
                mediaService.getMedia(mediaId).toVo()
        );
    }

    /**
     * 미디어 삭제
     * @param mediaId 미디어 ID
     * @return 미디어 삭제 응답
     */
    @Operation(summary = "Delete Media API", description = "Delete Media API 입니다.", tags = {"Media"})
    @DeleteMapping("/{mediaId}")
    public BaseResponse<Void> deleteMedia(@PathVariable Long mediaId) {
        mediaService.deleteMedia(mediaId);
        return new BaseResponse<>(
                BaseResponseStatus.SUCCESS
        );
    }

}
