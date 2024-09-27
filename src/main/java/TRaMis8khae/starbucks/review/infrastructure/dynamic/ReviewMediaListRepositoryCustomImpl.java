package TRaMis8khae.starbucks.review.infrastructure.dynamic;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static TRaMis8khae.starbucks.review.entity.QReviewMediaList.reviewMediaList;

@Repository
@RequiredArgsConstructor
public class ReviewMediaListRepositoryCustomImpl implements ReviewMediaListRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Long> findMediaIdsByReviewId(Long reviewId) {
        return queryFactory.select(reviewMediaList.mediaId)
                .from(reviewMediaList)
                .where(reviewMediaList.review.id.eq(reviewId))
                .fetch();
    }
}
