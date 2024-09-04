package TRaMis8khae.starbucks.member.application;

import TRaMis8khae.starbucks.member.dto.DeliveryAddressRequestDto;
import TRaMis8khae.starbucks.member.dto.DeliveryAddressResponseDto;
import TRaMis8khae.starbucks.member.entity.DeliveryAddress;
import TRaMis8khae.starbucks.member.entity.MemberAddressList;
import TRaMis8khae.starbucks.member.infrastructure.DeliveryAddressRepository;
import TRaMis8khae.starbucks.member.infrastructure.MemberAddressListRepository;
import TRaMis8khae.starbucks.member.vo.MemberAddressResponseVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    public DeliveryAddress addDeliveryAddress(String memberUUID, DeliveryAddressResponseDto deliveryAddressResponseDto) {
        // 배송지 추가
        DeliveryAddress deliveryAddress = DeliveryAddress.builder()
                .addressDetail(deliveryAddressResponseDto.getAddressDetail())
                .deliveryMemo(deliveryAddressResponseDto.getDeliveryMemo())
                .deliveryAddressNickname(deliveryAddressResponseDto.getDeliveryAddressNickname())
                .recipient(deliveryAddressResponseDto.getRecipient())
                .phone1(deliveryAddressResponseDto.getPhone1())
                .phone2(deliveryAddressResponseDto.getPhone2())
                .build();

        deliveryAddressRepository.save(deliveryAddress);

        MemberAddressList memberAddressList = MemberAddressList.builder()
                .memberUUID(memberUUID)
                .deliveryAddress(deliveryAddress)
                .addressDefaultCheck(deliveryAddressResponseDto.isAddressDefaultCheck())
                .build();

        memberAddressListRepository.save(memberAddressList);

        log.info("Delivery address added: {}", deliveryAddress);
        log.info("Member address list added: {}", memberAddressList);

        return deliveryAddress;
    }

    @Override
    public List<MemberAddressResponseVo> getMemberAddress(String memberUUID) {
        List<MemberAddressList> memberAddressList = memberAddressListRepository.findByMemberUUID(memberUUID);

        return memberAddressList.stream().map(memberAddress -> {
            DeliveryAddress deliveryAddress = memberAddress.getDeliveryAddress();
            return MemberAddressResponseVo.builder()
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
}
