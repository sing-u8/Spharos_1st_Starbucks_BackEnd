package TRaMis8khae.starbucks.purchase.infrastructure.dynamic;

import TRaMis8khae.starbucks.common.config.QueryDslConfig;
import TRaMis8khae.starbucks.purchase.dto.PurchaseReadResponseDto;
import TRaMis8khae.starbucks.purchase.entity.Purchase;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

import static TRaMis8khae.starbucks.purchase.entity.QPurchase.*;

@Repository
public class PurchaseRepositoryCustomImpl implements PurchaseRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public PurchaseRepositoryCustomImpl(EntityManager em) {
//        QueryDslConfig queryDslConfig = new QueryDslConfig();
//        this.queryFactory = queryDslConfig.jpaQueryFactory();
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Page<PurchaseReadResponseDto> findPurchases(Pageable pageable) {
        List<PurchaseReadResponseDto> content = queryFactory
                .select(Projections.constructor(PurchaseReadResponseDto.class,
                        purchase.serialNumber,
                        purchase.deliveryPrice,
                        purchase.totalPrice,
                        purchase.cardInfo,
                        purchase.memberName,
                        purchase.memberPhone,
                        purchase.addressDetail,
                        purchase.deliveryMemo,
                        purchase.deliveryAddressNickname,
                        purchase.recipient,
                        purchase.phone1,
                        purchase.phone2))
                .from(purchase)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Purchase> countQuery = queryFactory.selectFrom(purchase);

        return PageableExecutionUtils.getPage(content, pageable, countQuery::fetchCount);
    }
}