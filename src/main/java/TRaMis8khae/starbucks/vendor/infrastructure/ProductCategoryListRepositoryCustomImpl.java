package TRaMis8khae.starbucks.vendor.infrastructure;

import TRaMis8khae.starbucks.common.utils.CursorPage;
import TRaMis8khae.starbucks.product.entity.Product;
import TRaMis8khae.starbucks.product.entity.QProduct;
import TRaMis8khae.starbucks.vendor.entity.ProductCategoryList;
import TRaMis8khae.starbucks.vendor.entity.QProductCategoryList;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
@RequiredArgsConstructor
public class ProductCategoryListRepositoryCustomImpl implements ProductCategoryListRepositoryCustom {


	private static final int DEFAULT_PAGE_SIZE = 20;
	private static final int DEFAULT_PAGE_NUMBER = 0;

	private final JPAQueryFactory jpaQueryFactory;

	@Override
	public CursorPage<String> getProductCategoryListByCategories(
		String topCategoryCode,
		String middleCategoryCode,
		String bottomCategoryCode,
		Long lastId,
		Integer pageSize,
		Integer page
	) {

		QProductCategoryList productCategoryList = QProductCategoryList.productCategoryList;
		BooleanBuilder builder = new BooleanBuilder();

		// 카테고리 필터 적용
		Optional.ofNullable(topCategoryCode)
			.ifPresent(code -> builder.and(productCategoryList.topCode.eq(code)));

		Optional.ofNullable(middleCategoryCode)
			.ifPresent(code -> builder.and(productCategoryList.middleCode.eq(code)));

		Optional.ofNullable(bottomCategoryCode)
			.ifPresent(code -> builder.and(productCategoryList.bottomCode.eq(code)));

		// 마지막 ID 커서 적용
		Optional.ofNullable(lastId)
			.ifPresent(id -> builder.and(productCategoryList.id.lt(id)));

		// 페이지와 페이지 크기 기본값 설정
		int currentPage = Optional.ofNullable(page).orElse(DEFAULT_PAGE_NUMBER);
		int currentPageSize = Optional.ofNullable(pageSize).orElse(DEFAULT_PAGE_SIZE);

		// offset 계산
		int offset = currentPage == 0 ? 0 : (currentPage - 1) * currentPageSize;

		// 데이터 페칭 (pageSize + 1로 가져와서 다음 페이지 확인)
		List<ProductCategoryList> content = jpaQueryFactory
			.selectFrom(productCategoryList)
			.where(builder)
			.orderBy(productCategoryList.id.desc())
			.offset(offset)
			.limit(currentPageSize + 1)  // 다음 페이지 확인을 위해 pageSize + 1로 가져옴
			.fetch();

		// 다음 페이지의 커서 처리 및 hasNext 여부 판단
		Long nextCursor = null;
		boolean hasNext = false;

		if (content.size() > currentPageSize) {
			hasNext = true;
			content = content.subList(0, currentPageSize);  // 실제 페이지 사이즈 만큼 자르기
			nextCursor = content.get(content.size() - 1).getId();  // 마지막 항목의 ID를 커서로 설정
		}

		// productCode 리스트로 변환
		List<String> productUUIDs = content.stream()
			.map(ProductCategoryList::getProductUUID)
			.toList();

		// CursorPage 객체 반환
		return new CursorPage<>(productUUIDs, nextCursor, hasNext, currentPageSize, currentPage);
	}
}
