package TRaMis8khae.starbucks.wish.dto;

import TRaMis8khae.starbucks.wish.vo.WishAddResponseVo;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class WishReadResponseDto {

    private String productUUID;

    public WishAddResponseVo toVo() {
        return WishAddResponseVo.builder()
                .productUUID(productUUID)
                .build();
    }

}