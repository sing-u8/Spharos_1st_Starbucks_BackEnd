package TRaMis8khae.starbucks.product.infrastructure;


import TRaMis8khae.starbucks.product.dto.ProductResponseDto;
import TRaMis8khae.starbucks.product.entity.Product;
import TRaMis8khae.starbucks.product.entity.QProduct;
import TRaMis8khae.starbucks.product.entity.QProductMedia;
import TRaMis8khae.starbucks.product.entity.QProductOption;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class ProductRepositoryCustomImpl implements ProductRepositoryCustom{

	private final JPAQueryFactory jpaQueryFactory;

	QProduct product = QProduct.product;
	QProductOption productOption = QProductOption.productOption;
	QProductMedia productMedia = QProductMedia.productMedia;

	@Override
	public List<Product> getProductListWithPrice(Double minPrice, Double maxPrice) {

		return jpaQueryFactory
			.selectFrom(product)
			.where(product.price.between(minPrice, maxPrice))
			.fetch();
	}

//	List<Member> teamA = queryFactory
//		.selectFrom(member)
//		.join(member.team, team)
//		.where(team.name.eq("teamA"))
//		.fetch();
	public List<ProductResponseDto> getProducts() {
		return null;

	}

}
