package TRaMis8khae.starbucks.wish.application;

import TRaMis8khae.starbucks.wish.dto.WishAddRequestDto;
import TRaMis8khae.starbucks.wish.dto.WishReadResponseDto;
import TRaMis8khae.starbucks.wish.dto.WishUpdateRequestDto;
import TRaMis8khae.starbucks.wish.entity.Wish;
import TRaMis8khae.starbucks.wish.infrastructure.WishRepository;
import TRaMis8khae.starbucks.wish.vo.WishAddRequestVo;
import TRaMis8khae.starbucks.wish.vo.WishReadResponseVo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<WishReadResponseDto> findWishes(Pageable pageable) {
        return wishRepository.findWishes(pageable);
    }

    @Override
    public void unwish(String productUUID) {

        Wish wish = wishRepository.findByproductUUID(productUUID).orElseThrow();

        WishUpdateRequestDto dto = WishUpdateRequestDto.toDto(!wish.getWishChecked());

        Wish updatedWish = dto.toEntity(wish);

        wishRepository.save(updatedWish);
    }

}