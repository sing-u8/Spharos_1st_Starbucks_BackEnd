package TRaMis8khae.starbucks.common.specification;

import TRaMis8khae.starbucks.purchase.entity.Purchase;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecs {

    public static Specification<Purchase> withPrice(Double minPrice, Double maxPrice) {
        if ( minPrice == null && maxPrice == null ) {
            return ( root, query, builder ) -> builder.isNotNull(root.get("price"));
        } else if ( minPrice == null ) {
            return (root, query, builder) -> builder.lessThanOrEqualTo(root.get("price"), maxPrice);
        } else if ( maxPrice == null ) {
            return (root, query, builder) -> builder.greaterThanOrEqualTo(root.get("price"), minPrice);
        }
        return (root, query, builder) -> builder.between(root.get("price"), minPrice, maxPrice);
    }

}