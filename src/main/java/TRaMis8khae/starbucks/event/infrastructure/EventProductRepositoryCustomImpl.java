package TRaMis8khae.starbucks.event.infrastructure;

import TRaMis8khae.starbucks.product.entity.Product;
//import TRaMis8khae.starbucks.product.entity.QProduct;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EventProductRepositoryCustomImpl implements EventProductRepositoryCustom {

    @Override
    public Slice<Product> findByProductUUID(String productUUID, PageRequest pageRequest) {
        return null;
    }

//    private final JPAQueryFactory jpaQueryFactory;

//    QProduct product = QProduct.product;
//
//    @Override
//    public Slice<Product> findByProductUUID(String productUUID, PageRequest pageRequest) {
//        List<Product> products = jpaQueryFactory
//                .selectFrom(product)
//                .where(product.productUUID.eq(productUUID))
//                .offset(pageRequest.getOffset())
//                .limit(pageRequest.getPageSize() + 1)
//                .fetch();
//
//        boolean hasNext = products.size() > pageRequest.getPageSize();
//        if (hasNext) {
//            products.remove(products.size() - 1);
//        }
//
//        return new SliceImpl<>(products, pageRequest, hasNext);
//    }

}
