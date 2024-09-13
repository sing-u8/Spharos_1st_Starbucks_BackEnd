package TRaMis8khae.starbucks.wish.infrastructure;

import TRaMis8khae.starbucks.wish.entity.Wish;
import TRaMis8khae.starbucks.wish.infrastructure.dynamic.WishRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WishRepository extends JpaRepository<Wish, Long>, WishRepositoryCustom {

    Optional<Wish> findByproductUUID(String productUUID);

}