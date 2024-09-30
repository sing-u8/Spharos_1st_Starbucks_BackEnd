package TRaMis8khae.starbucks.wish.dto.out;

import TRaMis8khae.starbucks.wish.vo.out.WishReadResponseVo;
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