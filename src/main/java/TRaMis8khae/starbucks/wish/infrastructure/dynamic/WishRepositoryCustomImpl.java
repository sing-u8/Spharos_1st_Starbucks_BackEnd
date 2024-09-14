package TRaMis8khae.starbucks.wish.infrastructure.dynamic;

import TRaMis8khae.starbucks.wish.dto.WishReadResponseDto;
import TRaMis8khae.starbucks.wish.entity.Wish;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

import static TRaMis8khae.starbucks.wish.entity.QWish.*;

@Repository
@RequiredArgsConstructor
public class WishRepositoryCustomImpl implements WishRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<WishReadResponseDto> findWishes(Pageable pageable) {

        List<WishReadResponseDto> content = queryFactory
                .select(Projections.constructor(WishReadResponseDto.class,
                        wish.productUUID))
                .from(wish)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Wish> countQuery = queryFactory.selectFrom(wish);

        return PageableExecutionUtils.getPage(content, pageable, countQuery::fetchCount);
    }

}