package TRaMis8khae.starbucks.wish.application;

import TRaMis8khae.starbucks.wish.dto.in.WishAddRequestDto;
import TRaMis8khae.starbucks.wish.dto.out.WishReadResponseDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface WishService {

    void addWish(WishAddRequestDto requestDto);

    Slice<WishReadResponseDto> findWishes(Pageable pageable, String memberUUID);

}