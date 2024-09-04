package TRaMis8khae.starbucks.member.application;

import TRaMis8khae.starbucks.member.dto.DeliveryAddressRequestDto;
import TRaMis8khae.starbucks.member.dto.DeliveryAddressResponseDto;
import TRaMis8khae.starbucks.member.entity.DeliveryAddress;
import TRaMis8khae.starbucks.member.entity.MemberAddressList;
import TRaMis8khae.starbucks.member.infrastructure.DeliveryAddressRepository;
import TRaMis8khae.starbucks.member.infrastructure.MemberAddressListRepository;
import TRaMis8khae.starbucks.member.vo.MemberAddressRequestVo;
import TRaMis8khae.starbucks.member.vo.MemberAddressResponseVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.mapper.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class DeliveryAddressServiceImpl implements DeliveryAddressService{

    private final DeliveryAddressRepository deliveryAddressRepository;
    private final MemberAddressListRepository memberAddressListRepository;

    @Override
    public void addDeliveryAddress(String memberUUID, MemberAddressRequestVo memberAddressRequestVo) {
        // 배송지 추가
        DeliveryAddress deliveryAddress = DeliveryAddress.builder()
                .addressDetail(memberAddressRequestVo.getAddressDetail())
                .deliveryMemo(memberAddressRequestVo.getDeliveryMemo())
                .deliveryAddressNickname(memberAddressRequestVo.getDeliveryAddressNickname())
                .recipient(memberAddressRequestVo.getRecipient())
                .phone1(memberAddressRequestVo.getPhone1())
                .phone2(memberAddressRequestVo.getPhone2())
                .build();

        deliveryAddressRepository.save(deliveryAddress);

        // 회원 배송지 목록 추가
        MemberAddressList memberAddressList = MemberAddressList.builder()
                .memberUUID(memberUUID)
                .deliveryAddress(deliveryAddress)
                .addressDefaultCheck(memberAddressRequestVo.isAddressDefaultCheck())
                .build();

        memberAddressListRepository.save(memberAddressList);
    }

    @Override
    public List<MemberAddressResponseVo> getMemberDeliveryAddress(String memberUUID) {
        List<MemberAddressList> memberAddressList = memberAddressListRepository.findByMemberUUID(memberUUID);

        return memberAddressList.stream().map(memberAddress -> {
            DeliveryAddress deliveryAddress = memberAddress.getDeliveryAddress();
            return MemberAddressResponseVo.builder()
                    .deliveryAddressId(deliveryAddress.getDeliveryAddressId())
                    .memberAddressId(memberAddress.getMemberAddressId())
                    .memberUUID(memberAddress.getMemberUUID())
                    .addressDefaultCheck(memberAddress.getAddressDefaultCheck())
                    .addressDetail(deliveryAddress.getAddressDetail())
                    .deliveryMemo(deliveryAddress.getDeliveryMemo())
                    .deliveryAddressNickname(deliveryAddress.getDeliveryAddressNickname())
                    .recipient(deliveryAddress.getRecipient())
                    .phone1(deliveryAddress.getPhone1())
                    .phone2(deliveryAddress.getPhone2())
                    .build();
        }).collect(Collectors.toList());
    }

//    @Override
//    public void deleteDeliveryAddress(String memberUUID, Long deliveryAddressId) {
//        MemberAddressList memberAddressList = memberAddressListRepository.find
//
//    }

}
