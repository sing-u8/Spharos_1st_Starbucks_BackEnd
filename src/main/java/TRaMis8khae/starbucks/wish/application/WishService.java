package TRaMis8khae.starbucks.wish.application;

import TRaMis8khae.starbucks.wish.dto.WishAddRequestDto;
import TRaMis8khae.starbucks.wish.dto.WishReadResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface WishService {

    void addWish(WishAddRequestDto requestDto);

    Page<WishReadResponseDto> findWishes(Pageable pageable);

    void unwish(String productUUID);
}