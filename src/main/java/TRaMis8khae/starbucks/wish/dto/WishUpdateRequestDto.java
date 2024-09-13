package TRaMis8khae.starbucks.wish.dto;

import TRaMis8khae.starbucks.wish.entity.Wish;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class WishUpdateRequestDto {

    Boolean wishChecked;

    public static WishUpdateRequestDto toDto(Boolean toggleChecked) {
        return WishUpdateRequestDto.builder()
                .wishChecked(toggleChecked)
                .build();
    }

    public Wish toEntity(Wish wish) {
        return Wish.builder()
                .id(wish.getId())
                .productUUID(wish.getProductUUID())
                .memberUUID(wish.getMemberUUID())
                .wishChecked(this.wishChecked)
                .build();
    }

}