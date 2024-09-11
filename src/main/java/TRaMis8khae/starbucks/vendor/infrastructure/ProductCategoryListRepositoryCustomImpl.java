package TRaMis8khae.starbucks.vendor.infrastructure;

import TRaMis8khae.starbucks.product.entity.Product;
import TRaMis8khae.starbucks.product.entity.QProduct;
import TRaMis8khae.starbucks.vendor.entity.ProductCategoryList;
import TRaMis8khae.starbucks.vendor.entity.QProductCategoryList;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class ProductCategoryListRepositoryCustomImpl implements ProductCategoryListRepositoryCustom {

	private final JPAQueryFactory jpaQueryFactory;

	QProductCategoryList productCategoryList = QProductCategoryList.productCategoryList;
	QProduct product = QProduct.product;

	BooleanBuilder builder = new BooleanBuilder();

	@Override
	public List<ProductCategoryList> findProductsByCategories(String topCode, String middleCode) {

		if (topCode != null) {
			builder.and(productCategoryList.topCode.eq(topCode));
		}
		if (middleCode != null) {
			builder.and(productCategoryList.middleCode.eq(middleCode));
		}

		return jpaQueryFactory.selectFrom(productCategoryList)
			.where(builder)
			.fetch();
	}


}
