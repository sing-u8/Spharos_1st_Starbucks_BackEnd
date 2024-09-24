package TRaMis8khae.starbucks.wish.vo.in;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class WishAddRequestVo {

    private String productUUID;

    private Boolean wishChecked;

}