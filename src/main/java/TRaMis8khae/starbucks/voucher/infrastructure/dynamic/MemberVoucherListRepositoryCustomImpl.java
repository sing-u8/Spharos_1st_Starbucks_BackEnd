package TRaMis8khae.starbucks.voucher.infrastructure.dynamic;

import TRaMis8khae.starbucks.voucher.dto.out.VoucherReadResponseDto;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Repository;

import java.util.List;

import static TRaMis8khae.starbucks.voucher.entity.QMemberVoucherList.*;

@Repository
@RequiredArgsConstructor
public class MemberVoucherListRepositoryCustomImpl implements MemberVoucherListRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Slice<VoucherReadResponseDto> findVouchers(Pageable pageable, String memberUUID) {

        List<VoucherReadResponseDto> content = queryFactory.select(Projections.constructor(VoucherReadResponseDto.class,
                        memberVoucherList.memberUUID,
                        memberVoucherList.registDate,
                        memberVoucherList.voucher.name,
                        memberVoucherList.voucher.price,
                        memberVoucherList.voucher.productUUID,
                        memberVoucherList.voucher.expireDate,
                        memberVoucherList.voucher.voucherCode))
                .from(memberVoucherList)
                .where(eqMemberUUID(memberUUID))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        boolean hasNext = content.size() == pageable.getPageSize(); // 다음 페이지가 있는지 확인

        return new SliceImpl<>(content, pageable, hasNext);
    }

    public BooleanExpression eqMemberUUID(String memberUUID) {
        return memberVoucherList.memberUUID.eq(memberUUID);
    }

}