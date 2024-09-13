package TRaMis8khae.starbucks.wish.dto;

import TRaMis8khae.starbucks.wish.vo.WishResponseVo;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class WishReadResponseDto {

    private String productUUID;

    public WishResponseVo toVo() {
        return WishResponseVo.builder()
                .productUUID(productUUID)
                .build();
    }

}