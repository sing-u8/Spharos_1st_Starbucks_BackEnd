package TRaMis8khae.starbucks.member.infrastructure;

import TRaMis8khae.starbucks.member.entity.QDeliveryAddress;
import TRaMis8khae.starbucks.member.entity.QMemberAddressList;
import TRaMis8khae.starbucks.member.vo.DeliveryAddressResponseVo;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberAddressListRepositoryImpl implements MemberAddressListRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<DeliveryAddressResponseVo> findMemberAddressWithDeliveryAddress(String memberUUID){
        QMemberAddressList qMemberAddressList = QMemberAddressList.memberAddressList;
        QDeliveryAddress qDeliveryAddress = QDeliveryAddress.deliveryAddress;

        return jpaQueryFactory.select(Projections.constructor(DeliveryAddressResponseVo.class,
                        qMemberAddressList.id,
                        qMemberAddressList.memberUUID,
                        qMemberAddressList.addressDefaultCheck,
                        qDeliveryAddress.id,
                        qDeliveryAddress.addressDetail,
                        qDeliveryAddress.deliveryMemo,
                        qDeliveryAddress.deliveryAddressNickname,
                        qDeliveryAddress.recipient,
                        qDeliveryAddress.phone1,
                        qDeliveryAddress.phone2))
                .from(qMemberAddressList)
                .join(qMemberAddressList.deliveryAddress, qDeliveryAddress)
                .where(qMemberAddressList.memberUUID.eq(memberUUID))
                .fetch();
    }

}
