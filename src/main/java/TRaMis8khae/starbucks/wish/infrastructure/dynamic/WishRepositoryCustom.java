package TRaMis8khae.starbucks.wish.infrastructure.dynamic;

import TRaMis8khae.starbucks.wish.dto.out.WishReadResponseDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface WishRepositoryCustom {

    Slice<WishReadResponseDto> findWishes(Pageable pageable, String memberUUID);

}