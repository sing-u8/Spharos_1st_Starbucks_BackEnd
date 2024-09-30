package TRaMis8khae.starbucks.purchase.infrastructure.dynamic;

import TRaMis8khae.starbucks.purchase.dto.out.PurchaseReadResponseDto;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Repository;

import java.util.List;

import static TRaMis8khae.starbucks.purchase.entity.QPurchase.*;

@Repository
@RequiredArgsConstructor
public class PurchaseRepositoryCustomImpl implements PurchaseRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Slice<PurchaseReadResponseDto> findPurchases(Pageable pageable, String memberUUID) {
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
                        purchase.recipient,
                        purchase.phone1,
                        purchase.phone2))
                .from(purchase)
                .where(eqMemberUUID(memberUUID))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        boolean hasNext = content.size() == pageable.getPageSize(); // 다음 페이지가 있는지 확인

        return new SliceImpl<>(content, pageable, hasNext);
    }

    public BooleanExpression eqMemberUUID(String memberUUID) {
        return purchase.memberUUID.eq(memberUUID);
    }

}