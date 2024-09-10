package TRaMis8khae.starbucks.member.application;

import TRaMis8khae.starbucks.common.entity.CommonResponseEntity;
import TRaMis8khae.starbucks.member.dto.DeliveryAddressRequestDto;
import TRaMis8khae.starbucks.member.dto.DeliveryAddressResponseDto;
import TRaMis8khae.starbucks.member.entity.DeliveryAddress;
import TRaMis8khae.starbucks.member.entity.MemberAddressList;
import TRaMis8khae.starbucks.member.infrastructure.DeliveryAddressRepository;
import TRaMis8khae.starbucks.member.infrastructure.MemberAddressListRepository;
import TRaMis8khae.starbucks.member.infrastructure.MemberAddressListRepositoryCustom;
import TRaMis8khae.starbucks.member.vo.MemberAddressRequestVo;
import TRaMis8khae.starbucks.member.vo.MemberAddressResponseVo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class DeliveryAddressServiceImpl implements DeliveryAddressService{

    private final DeliveryAddressRepository deliveryAddressRepository;
    private final MemberAddressListRepository memberAddressListRepository;
    private final MemberAddressListRepositoryCustom memberAddressListRepositoryCustom;

    @Override
    public void addDeliveryAddress(String memberUUID, MemberAddressRequestVo memberAddressRequestVo) {
        DeliveryAddress deliveryAddress = DeliveryAddress.builder()
                .addressDetail(memberAddressRequestVo.getAddressDetail())
                .deliveryMemo(memberAddressRequestVo.getDeliveryMemo())
                .deliveryAddressNickname(memberAddressRequestVo.getDeliveryAddressNickname())
                .recipient(memberAddressRequestVo.getRecipient())
                .phone1(memberAddressRequestVo.getPhone1())
                .phone2(memberAddressRequestVo.getPhone2())
                .build();

        deliveryAddressRepository.save(deliveryAddress);

        MemberAddressList memberAddressList = MemberAddressList.builder()
                .memberUUID(memberUUID)
                .deliveryAddress(deliveryAddress)
                .addressDefaultCheck(memberAddressRequestVo.isAddressDefaultCheck())
                .build();

        memberAddressListRepository.save(memberAddressList);
    }

    @Override
    public List<DeliveryAddressResponseDto> getMemberDeliveryAddress(String memberUUID) {

        List<MemberAddressResponseVo> memberAddressResponseVoList = memberAddressListRepositoryCustom.findMemberAddressWithDeliveryAddress(memberUUID);

        return memberAddressResponseVoList.stream()
                .map(vo -> DeliveryAddressResponseDto.builder()
                        .addressDefaultCheck(vo.isAddressDefaultCheck())
                        .addressDetail(vo.getAddressDetail())
                        .deliveryMemo(vo.getDeliveryMemo())
                        .deliveryAddressNickname(vo.getDeliveryAddressNickname())
                        .recipient(vo.getRecipient())
                        .phone1(vo.getPhone1())
                        .phone2(vo.getPhone2())
                        .build())
                .collect(Collectors.toList());

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
    public void updateDeliveryAddress(String memberUUID, Long id, MemberAddressRequestVo memberAddressRequestVo) {

        Optional<DeliveryAddress> updateDeliveryAddress = deliveryAddressRepository.findById(id);

        if(updateDeliveryAddress.isEmpty()){
            throw new IllegalArgumentException("해당 배송지가 존재하지 않습니다.");
        }

        DeliveryAddress deliveryAddress = updateDeliveryAddress.get();

        deliveryAddress.updateDeliveryAddress(
                memberAddressRequestVo.getAddressDetail(),
                memberAddressRequestVo.getDeliveryMemo(),
                memberAddressRequestVo.getDeliveryAddressNickname(),
                memberAddressRequestVo.getRecipient(),
                memberAddressRequestVo.getPhone1(),
                memberAddressRequestVo.getPhone2()
        );

        MemberAddressList memberAddressList = memberAddressListRepository.findByMemberUUIDAndId(memberUUID, id);
        memberAddressList.updateMemberAddressList(memberAddressRequestVo.isAddressDefaultCheck());

        deliveryAddressRepository.save(deliveryAddress);
        memberAddressListRepository.save(memberAddressList);

    }


//    @Override
//    public void deleteDeliveryAddress(String memberUUID, Long deliveryAddressId) {
//        MemberAddressList memberAddressList = memberAddressListRepository.find
//
//    }

}
