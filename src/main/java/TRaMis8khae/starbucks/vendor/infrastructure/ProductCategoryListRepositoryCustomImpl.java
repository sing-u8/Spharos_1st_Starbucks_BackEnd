package TRaMis8khae.starbucks.vendor.infrastructure;

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

	BooleanBuilder builder = new BooleanBuilder();

	@Override
	public List<ProductCategoryList> findProductsByCategories(String mainCode, String subCode) {

		if (mainCode != null) {
			builder.and(productCategoryList.mainCode.eq(mainCode));
		}
		if (subCode != null) {
			builder.and(productCategoryList.subCode.eq(subCode));
		}

		return jpaQueryFactory.selectFrom(productCategoryList)
			.where(builder)
			.fetch();
	}

}
