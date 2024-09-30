package TRaMis8khae.starbucks.product.infrastructure;


import TRaMis8khae.starbucks.product.entity.*;
import TRaMis8khae.starbucks.vendor.entity.QProductOption;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


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
