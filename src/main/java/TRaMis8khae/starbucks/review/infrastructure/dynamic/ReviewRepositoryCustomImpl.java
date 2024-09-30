package TRaMis8khae.starbucks.review.infrastructure.dynamic;

import TRaMis8khae.starbucks.review.dto.out.ReviewReadResponseDto;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Repository;

import java.util.List;

import static TRaMis8khae.starbucks.review.entity.QReview.*;
import static TRaMis8khae.starbucks.review.entity.QReviewMediaList.reviewMediaList;
import static com.querydsl.core.types.dsl.Expressions.list;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryCustomImpl implements ReviewRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<ReviewReadResponseDto> findReviews(Pageable pageable, String productUUID) {
        return queryFactory
                .select(Projections.constructor(ReviewReadResponseDto.class,
                        review.id,
                        review.productUUID,
                        review.memberMaskingId,
                        review.reviewContext,
                        review.reviewScore,
                        review.updatedAt
//                        reviewMediaList.mediaId
                ))
                .from(review)
//                    .leftJoin(reviewMediaList)
//                    .on(review.id.eq(reviewMediaList.review.id))
                .where(eqProductUUID(productUUID))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

//        List<ReviewReadResponseDto> content = queryFactory
//                .select(Projections.constructor(ReviewReadResponseDto.class,
//                        review.productUUID,
//                        review.memberMaskingId,
//                        review.reviewContext,
//                        review.reviewScore,
//                        review.updatedAt,
//                        list(reviewMediaList.mediaId) // mediaId를 리스트로 변환
//                ))
//                .from(review)
//                .leftJoin(reviewMediaList).on(review.id.eq(reviewMediaList.review.id))
//                .where(eqProductUUID(productUUID))
//                .groupBy(review.id) // 리뷰별로 그룹화
//                .offset(pageable.getOffset())
//                .limit(pageable.getPageSize())
//                .fetch();

//        List<ReviewReadResponseDto> content = queryFactory
//                .select(Projections.fields(ReviewReadResponseDto.class,
//                        review.productUUID,
//                        review.memberMaskingId,
//                        review.reviewContext,
//                        review.reviewScore,
//                        review.updatedAt,
//                        ExpressionUtils.as( // 서브쿼리로 mediaId 리스트를 가져와서 리스트로 변환
//                                JPAExpressions
//                                        .select(reviewMediaList.mediaId)
//                                        .from(reviewMediaList)
//                                        .where(reviewMediaList.review.id.eq(review.id)),
//                                "mediaIdList" // DTO에서 필드 이름과 맞춰줘야 함
//                        )
//                ))
//                .from(review)
//                .leftJoin(reviewMediaList).on(review.id.eq(reviewMediaList.review.id))
//                .where(eqProductUUID(productUUID))
//                .groupBy(review.id)
//                .offset(pageable.getOffset())
//                .limit(pageable.getPageSize())
//                .fetch();
    }

    public BooleanExpression eqProductUUID(String productUUID) {
        return review.productUUID.eq(productUUID);
    }

}