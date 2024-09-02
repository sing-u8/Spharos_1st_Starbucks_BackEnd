package TRaMis8khae.starbucks.product.infrastructure;

import com.querydsl.core.group.GroupBy;
import TRaMis8khae.starbucks.product.domain.ProductInfoList;
import TRaMis8khae.starbucks.product.domain.QProduct;
import TRaMis8khae.starbucks.product.domain.QProductInfo;
import TRaMis8khae.starbucks.product.domain.QProductInfoList;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Repository
public class ProductRepositoryImpl implements ProductRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<ProductInfoList> getProductInfoWithProduct(String productUuid) {

        QProductInfoList productInfoList = QProductInfoList.productInfoList;
        QProductInfo productInfo = QProductInfo.productInfo1;

        return jpaQueryFactory.selectFrom(productInfoList)
                .innerJoin(productInfo)
                .where(productInfoList.productUuid.eq(productUuid))
//                        .and(productInfo.productInfoId.eq(productInfoList.productInfoId)))
                .fetch();
    }
}
