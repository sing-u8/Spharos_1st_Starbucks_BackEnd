package TRaMis8khae.starbucks.wish.infrastructure.dynamic;

import TRaMis8khae.starbucks.wish.dto.WishReadResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface WishRepositoryCustom {

    Page<WishReadResponseDto> findWishes(Pageable pageable);

}