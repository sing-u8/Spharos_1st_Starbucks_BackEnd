package TRaMis8khae.starbucks.member.application;

import TRaMis8khae.starbucks.member.dto.DeliveryAddressDto;
import TRaMis8khae.starbucks.member.dto.MemberAddressListDto;
import TRaMis8khae.starbucks.member.entity.DeliveryAddress;
import TRaMis8khae.starbucks.member.entity.MemberAddressList;
import TRaMis8khae.starbucks.member.infrastructure.DeliveryAddressRepository;
import TRaMis8khae.starbucks.member.infrastructure.MemberAddressListRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class DeliveryAddressServiceImpl implements DeliveryAddressService{

    private final DeliveryAddressRepository deliveryAddressRepository;
    private final MemberAddressListRepository memberAddressListRepository;

    @Override
    public DeliveryAddress addDeliveryAddress(String memberUUID, DeliveryAddressDto deliveryAddressDto) {
        // 배송지 추가
        DeliveryAddress deliveryAddress = DeliveryAddress.builder()
                .addressDetail(deliveryAddressDto.getAddressDetail())
                .deliveryMemo(deliveryAddressDto.getDeliveryMemo())
                .deliveryAddressNickname(deliveryAddressDto.getDeliveryAddressNickname())
                .recipient(deliveryAddressDto.getRecipient())
                .phone1(deliveryAddressDto.getPhone1())
                .phone2(deliveryAddressDto.getPhone2())
                .build();

        deliveryAddressRepository.save(deliveryAddress);

        MemberAddressList memberAddressList = MemberAddressList.builder()
                .memberUUID(memberUUID)
                .deliveryAddress(deliveryAddress)
                .build();

        memberAddressListRepository.save(memberAddressList);

        log.info("Delivery address added: {}", deliveryAddress);
        log.info("Member address list added: {}", memberAddressList);

        return deliveryAddress;
    }


//    @Override
//    public Optional<DeliveryAddress> getDeliveryAddress(Long deliveryAddressId) {
//        return deliveryAddressRepository.findById(deliveryAddressId);
//    }

//    @Override
//    public MemberAddress addMemberAddress(MemberAddressDto dto) {
//        DeliveryAddress deliveryAddress = deliveryAddressRepository.findById(dto.getDeliveryAddressId())
//                .orElseThrow(() -> new IllegalArgumentException("Invalid delivery address ID"));
//        MemberAddress memberAddress = MemberAddress.builder()
//                .memberUUID(dto.getMemberUUID())
//                .deliveryAddress(deliveryAddress)
//                .addressDefaultCheck(dto.getAddressDefaultCheck())
//                .build();
//        return memberAddressRepository.save(memberAddress);
//    }
}
