package TRaMis8khae.starbucks.wish.vo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class WishAddRequestVo {

    private String memberUUID;

    private String productUUID;

}