package TRaMis8khae.starbucks.product.infrastructure;


import TRaMis8khae.starbucks.product.entity.*;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class ProductRepositoryCustomImpl implements ProductRepositoryCustom{

	private final JPAQueryFactory jpaQueryFactory;

	QProduct product = QProduct.product;

	@Override
	public List<Product> getProductListWithPrice(Double minPrice, Double maxPrice) {

		return jpaQueryFactory
			.selectFrom(product)
			.where(product.price.between(minPrice, maxPrice))
			.fetch();
	}
}
