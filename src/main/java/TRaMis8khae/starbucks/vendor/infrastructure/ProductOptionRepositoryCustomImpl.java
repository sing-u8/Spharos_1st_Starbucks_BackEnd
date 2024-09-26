package TRaMis8khae.starbucks.vendor.infrastructure;


import TRaMis8khae.starbucks.product.entity.Product;
import TRaMis8khae.starbucks.product.entity.QProduct;
import TRaMis8khae.starbucks.vendor.entity.QProductOption;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductOptionRepositoryCustomImpl implements ProductOptionRepositoryCustom{

	private final JPAQueryFactory jpaQueryFactory;

	@Override
	public List<String> getProductUUIDByVolume(String volumeName) {

		QProductOption productOption = QProductOption.productOption;

		return jpaQueryFactory
			.select(productOption.productUUID)
			.from(productOption)
			.where(productOption.volume.name.eq(volumeName))
			.fetch();
	}
}
