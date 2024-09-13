package TRaMis8khae.starbucks.wish.dto;

import TRaMis8khae.starbucks.wish.vo.WishReadResponseVo;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class WishReadResponseDto {

    private String productUUID;

    public WishReadResponseVo toVo() {
        return WishReadResponseVo.builder()
                .productUUID(productUUID)
                .build();
    }

}