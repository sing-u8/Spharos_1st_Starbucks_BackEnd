package TRaMis8khae.starbucks.product.infrastructure;

import TRaMis8khae.starbucks.product.entity.ProductInfoList;
import TRaMis8khae.starbucks.product.entity.QProductInfo;
import TRaMis8khae.starbucks.product.entity.QProductInfoList;
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
        QProductInfo productInfo = QProductInfo.productInfo1;

        return jpaQueryFactory.selectFrom(productInfoList)
                .innerJoin(productInfo)
                .where(productInfoList.productUUID.eq(productUUID))
//                        .and(productInfo.productInfoId.eq(productInfoList.productInfoId)))
                .fetch();
    }
}
