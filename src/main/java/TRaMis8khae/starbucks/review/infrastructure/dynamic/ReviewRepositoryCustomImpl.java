package TRaMis8khae.starbucks.review.infrastructure.dynamic;

import TRaMis8khae.starbucks.review.dto.ReviewReadResponseDto;
import TRaMis8khae.starbucks.review.entity.Review;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

import static TRaMis8khae.starbucks.review.entity.QReview.*;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryCustomImpl implements ReviewRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<ReviewReadResponseDto> findReviews(Pageable pageable) {
        List<ReviewReadResponseDto> content = queryFactory
                .select(Projections.constructor(ReviewReadResponseDto.class,
                        review.productUUID,
                        review.memberUUID,
                        review.memberMaskingId,
                        review.memberNickname,
                        review.reviewTitle,
                        review.reviewContext,
                        review.reviewScore))
                .from(review)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Review> countQuery = queryFactory.selectFrom(review);

        return PageableExecutionUtils.getPage(content, pageable, countQuery::fetchCount);
    }

}