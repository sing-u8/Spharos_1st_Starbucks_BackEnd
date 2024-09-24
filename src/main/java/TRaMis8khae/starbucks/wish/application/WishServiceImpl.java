package TRaMis8khae.starbucks.wish.application;

import TRaMis8khae.starbucks.wish.dto.in.WishAddRequestDto;
import TRaMis8khae.starbucks.wish.dto.out.WishReadResponseDto;
import TRaMis8khae.starbucks.wish.entity.Wish;
import TRaMis8khae.starbucks.wish.infrastructure.WishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WishServiceImpl implements WishService {

    private final WishRepository wishRepository;

    @Override
    public void addWish(WishAddRequestDto requestDto) {

        Wish wish = requestDto.toEntity();

        wishRepository.save(wish);
    }

    @Override
    public Slice<WishReadResponseDto> findWishes(Pageable pageable, String memberUUID) {
        return wishRepository.findWishes(pageable, memberUUID);
    }

}