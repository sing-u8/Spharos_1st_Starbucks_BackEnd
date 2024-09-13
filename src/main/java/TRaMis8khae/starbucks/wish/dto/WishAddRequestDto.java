package TRaMis8khae.starbucks.wish.dto;

import TRaMis8khae.starbucks.wish.entity.Wish;
import TRaMis8khae.starbucks.wish.vo.WishAddRequestVo;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class WishAddRequestDto {

    private String memberUUID;

    private String productUUID;

    public static WishAddRequestDto toDto(WishAddRequestVo vo) {
        return WishAddRequestDto.builder()
                .memberUUID(vo.getMemberUUID())
                .productUUID(vo.getProductUUID())
                .build();
    }

    public Wish toEntity() {
        return Wish.builder()
                .memberUUID(this.memberUUID)
                .productUUID(this.productUUID)
                .wishChecked(true)
                .build();
    }

}