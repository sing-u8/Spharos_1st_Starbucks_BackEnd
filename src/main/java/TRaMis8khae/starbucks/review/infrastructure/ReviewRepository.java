package TRaMis8khae.starbucks.review.infrastructure;

import TRaMis8khae.starbucks.review.entity.Review;
import TRaMis8khae.starbucks.review.infrastructure.dynamic.ReviewRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewRepositoryCustom {

    Optional<Review> findByReviewUUID(String reviewUUID);

    void deleteByReviewUUIDAndMemberUUID(String reviewUUID, String memberUUID);

}