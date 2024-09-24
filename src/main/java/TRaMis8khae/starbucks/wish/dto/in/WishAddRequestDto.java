package TRaMis8khae.starbucks.wish.dto.in;

import TRaMis8khae.starbucks.wish.entity.Wish;
import TRaMis8khae.starbucks.wish.vo.in.WishAddRequestVo;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class WishAddRequestDto {

    private String memberUUID;

    private String productUUID;

    private Boolean wishChecked;

    public static WishAddRequestDto toDto(WishAddRequestVo vo, String memberUUID) {
        return WishAddRequestDto.builder()
                .memberUUID(memberUUID)
                .productUUID(vo.getProductUUID())
                .wishChecked(vo.getWishChecked())
                .build();
    }

    public Wish toEntity() {
        return Wish.builder()
                .memberUUID(this.memberUUID)
                .productUUID(this.productUUID)
                .wishChecked(!this.wishChecked)
                .build();
    }

}