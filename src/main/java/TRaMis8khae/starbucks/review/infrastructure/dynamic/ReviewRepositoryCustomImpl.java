package TRaMis8khae.starbucks.review.infrastructure.dynamic;

import TRaMis8khae.starbucks.review.dto.out.ReviewReadResponseDto;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Repository;

import java.util.List;

import static TRaMis8khae.starbucks.review.entity.QReview.*;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryCustomImpl implements ReviewRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Slice<ReviewReadResponseDto> findReviews(Pageable pageable, String productUUID) {
        List<ReviewReadResponseDto> content = queryFactory
                .select(Projections.constructor(ReviewReadResponseDto.class,
                        review.productUUID,
                        review.memberUUID,
                        review.memberMaskingId,
                        review.reviewContext,
                        review.reviewScore))
                .from(review)
                .where(eqProductUUID(productUUID))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        boolean hasNext = content.size() == pageable.getPageSize(); // 다음 페이지가 있는지 확인

        return new SliceImpl<>(content, pageable, hasNext);
    }

    public BooleanExpression eqProductUUID(String productUUID) {
        return review.productUUID.eq(productUUID);
    }

}