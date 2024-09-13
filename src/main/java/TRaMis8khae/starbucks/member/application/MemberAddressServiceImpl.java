package TRaMis8khae.starbucks.member.application;

import TRaMis8khae.starbucks.member.dto.DeliveryAddressRequestDto;
import TRaMis8khae.starbucks.member.dto.DeliveryAddressResponseDto;
import TRaMis8khae.starbucks.member.dto.MemberAddressListRequestDto;
import TRaMis8khae.starbucks.member.entity.DeliveryAddress;
import TRaMis8khae.starbucks.member.entity.Member;
import TRaMis8khae.starbucks.member.entity.MemberAddressList;
import TRaMis8khae.starbucks.member.infrastructure.DeliveryAddressRepository;
import TRaMis8khae.starbucks.member.infrastructure.MemberAddressListRepository;
import TRaMis8khae.starbucks.member.infrastructure.MemberAddressListRepositoryCustom;
import TRaMis8khae.starbucks.member.infrastructure.MemberRepository;
import TRaMis8khae.starbucks.member.vo.DeliveryAddressResponseVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberAddressServiceImpl implements MemberAddressService {

    private final DeliveryAddressRepository deliveryAddressRepository;
    private final MemberAddressListRepository memberAddressListRepository;
    private final MemberAddressListRepositoryCustom memberAddressListRepositoryCustom;
    private final MemberRepository memberRepository;

    @Override
    public void addDeliveryAddress(String memberUUID, DeliveryAddressRequestDto deliveryAddressRequestDto) {
//        DeliveryAddress deliveryAddress = DeliveryAddress.builder()
//                .addressDetail(memberDeliveryAddressRequestVo.getAddressDetail())
//                .deliveryMemo(memberDeliveryAddressRequestVo.getDeliveryMemo())
//                .deliveryAddressNickname(memberDeliveryAddressRequestVo.getDeliveryAddressNickname())
//                .recipient(memberDeliveryAddressRequestVo.getRecipient())
//                .phone1(memberDeliveryAddressRequestVo.getPhone1())
//                .phone2(memberDeliveryAddressRequestVo.getPhone2())
//                .build();
//
//        deliveryAddressRepository.save(deliveryAddress);
//
//        MemberAddressList memberAddressList = MemberAddressList.builder()
//                .memberUUID(memberUUID)
//                .deliveryAddress(deliveryAddress)
//                .addressDefaultCheck(memberDeliveryAddressRequestVo.isAddressDefaultCheck())
//                .build();
//
//        memberAddressListRepository.save(memberAddressList);
        Member member = memberRepository.findByMemberUUID(memberUUID) // memberUUID로 Member를 찾아옴
                .orElseThrow(() -> new IllegalArgumentException("해당 멤버가 존재하지 않습니다.")); // 없으면 예외 발생


        log.info("member!!! : {}", member);
        log.info("requestDto!!! : {}", deliveryAddressRequestDto);

//        DeliveryAddress addDeliveryAddress = deliveryAddressRequestDto.toEntity();
//        MemberAddressList memberAddressList = deliveryAddressRequestDto.toEntity();

//        deliveryAddressRepository.save(addDeliveryAddress);
//        memberAddressListRepository.save(memberAddressList);

    }

    @Override
    public List<DeliveryAddressResponseDto> getMemberDeliveryAddress(String memberUUID) {

        List<DeliveryAddressResponseVo> deliveryAddressList = memberAddressListRepositoryCustom.findMemberAddressWithDeliveryAddress(memberUUID);

//        return

//                memberDeliveryAddressResponseVoList.stream()
//                .map(vo -> DeliveryAddressResponseDto.builder()
//                        .addressDefaultCheck(vo.isAddressDefaultCheck())
//                        .addressDetail(vo.getAddressDetail())
//                        .deliveryMemo(vo.getDeliveryMemo())
//                        .deliveryAddressNickname(vo.getDeliveryAddressNickname())
//                        .recipient(vo.getRecipient())
//                        .phone1(vo.getPhone1())
//                        .phone2(vo.getPhone2())
//                        .build())
//                .collect(Collectors.toList());

        return null;
    }

    @Override
    public void deleteDeliveryAddress(Long deliveryAddressId) {

        Optional<MemberAddressList> findMemberAddressList = memberAddressListRepository.findById(deliveryAddressId);

        if (findMemberAddressList.isEmpty()) {
            throw new IllegalArgumentException("해당 배송지가 리스트에 존재하지 않습니다.");
        }

        MemberAddressList memberAddressList = findMemberAddressList.get();

        memberAddressListRepository.delete(memberAddressList);


        Optional<DeliveryAddress> findDeliveryAddress = deliveryAddressRepository.findById(deliveryAddressId);

        if(findDeliveryAddress.isEmpty()){
            throw new IllegalArgumentException("해당 배송지가 존재하지 않습니다.");
        }

        DeliveryAddress deliveryAddress = findDeliveryAddress.get();

        deliveryAddressRepository.delete(deliveryAddress);

    }

    @Override
    public void updateDeliveryAddress(String memberUUID, Long id, DeliveryAddressRequestDto deliveryAddressRequestDto) {

        Optional<DeliveryAddress> updateDeliveryAddress = deliveryAddressRepository.findById(id);

        if(updateDeliveryAddress.isEmpty()){
            throw new IllegalArgumentException("해당 배송지가 존재하지 않습니다.");
        }

        DeliveryAddress deliveryAddress = updateDeliveryAddress.get();

        deliveryAddress.updateDeliveryAddress(
                deliveryAddressRequestDto.getAddressDetail(),
                deliveryAddressRequestDto.getDeliveryMemo(),
                deliveryAddressRequestDto.getDeliveryAddressNickname(),
                deliveryAddressRequestDto.getRecipient(),
                deliveryAddressRequestDto.getPhone1(),
                deliveryAddressRequestDto.getPhone2()
        );

        MemberAddressList memberAddressList = memberAddressListRepository.findByMemberUUIDAndId(memberUUID, id);
        memberAddressList.updateMemberAddressList(deliveryAddressRequestDto.isAddressDefaultCheck());

        deliveryAddressRepository.save(deliveryAddress);
        memberAddressListRepository.save(memberAddressList);

    }


//    @Override
//    public void deleteDeliveryAddress(String memberUUID, Long deliveryAddressId) {
//        MemberAddressList memberAddressList = memberAddressListRepository.find
//
//    }

}
