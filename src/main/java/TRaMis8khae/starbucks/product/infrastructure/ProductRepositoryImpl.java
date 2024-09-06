package TRaMis8khae.starbucks.product.infrastructure;

import TRaMis8khae.starbucks.product.entity.*;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class ProductRepositoryImpl implements ProductRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<ProductInfoList> getProductInfoWithProduct(String productUUID) {

        QProductInfoList productInfoList = QProductInfoList.productInfoList;

        return jpaQueryFactory.selectFrom(productInfoList)
                .where(productInfoList.productUUID.eq(productUUID))
                .fetch();

    }

    @Override
    public List<ProductOption> getProductOptionWithProduct(String productUUID) {
        QProductOption productOption = QProductOption.productOption;

        return jpaQueryFactory.selectFrom(productOption)
                .where(productOption.productUUID.eq(productUUID))
                .fetch();
    }
}
