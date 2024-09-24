package TRaMis8khae.starbucks.wish.infrastructure.dynamic;

import TRaMis8khae.starbucks.wish.dto.out.WishReadResponseDto;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Repository;

import java.util.List;

import static TRaMis8khae.starbucks.wish.entity.QWish.*;

@Repository
@RequiredArgsConstructor
public class WishRepositoryCustomImpl implements WishRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Slice<WishReadResponseDto> findWishes(Pageable pageable, String memberUUID) {

        List<WishReadResponseDto> content = queryFactory
                .select(Projections.constructor(WishReadResponseDto.class,
                        wish.productUUID))
                .from(wish)
                .where(eqMemberUUID(memberUUID))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        boolean hasNext = content.size() == pageable.getPageSize(); // 다음 페이지가 있는지 확인

        return new SliceImpl<>(content, pageable, hasNext);
    }

    public BooleanExpression eqMemberUUID(String memberUUID) {
        return wish.memberUUID.eq(memberUUID);
    }

}