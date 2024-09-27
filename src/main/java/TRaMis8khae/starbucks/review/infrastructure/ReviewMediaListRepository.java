package TRaMis8khae.starbucks.review.infrastructure;

import TRaMis8khae.starbucks.review.entity.ReviewMediaList;
import TRaMis8khae.starbucks.review.infrastructure.dynamic.ReviewMediaListRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReviewMediaListRepository extends JpaRepository<ReviewMediaList, Long>, ReviewMediaListRepositoryCustom {
}