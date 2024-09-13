package TRaMis8khae.starbucks.member.application;

import TRaMis8khae.starbucks.member.dto.DeliveryAddressRequestDto;
import TRaMis8khae.starbucks.member.dto.DeliveryAddressResponseDto;
import TRaMis8khae.starbucks.member.dto.MemberAddressListRequestDto;
import TRaMis8khae.starbucks.member.dto.UpdateDeliveryAddressRequestDto;
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
import java.util.stream.Collectors;

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

        Member member = memberRepository.findByMemberUUID(memberUUID) // memberUUID로 Member를 찾아옴
                .orElseThrow(() -> new IllegalArgumentException("해당 멤버가 존재하지 않습니다.")); // 없으면 예외 발생

        DeliveryAddress addDeliveryAddress = deliveryAddressRequestDto.toEntity(deliveryAddressRequestDto);

        deliveryAddressRepository.save(addDeliveryAddress);

        MemberAddressList memberAddressList = MemberAddressListRequestDto.toEntity(deliveryAddressRequestDto, addDeliveryAddress, memberUUID);

        memberAddressListRepository.save(memberAddressList);

    }

    @Override
    public List<DeliveryAddressResponseDto> getMemberDeliveryAddress(String memberUUID) {

        List<DeliveryAddressResponseVo> deliveryAddressList = memberAddressListRepositoryCustom
                .findMemberAddressWithDeliveryAddress(memberUUID);

        return deliveryAddressList.stream()
                .map(DeliveryAddressResponseDto::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteDeliveryAddress(Long deliveryAddressId) {


        DeliveryAddress deliveryAddress = deliveryAddressRepository.findDeliveryAddressById(deliveryAddressId);
        MemberAddressList memberAddressList = memberAddressListRepository.findByDeliveryAddress(deliveryAddress);

        if (deliveryAddress == null) {
            throw new IllegalArgumentException("해당 배송지가 존재하지 않습니다.");
        }

        memberAddressListRepository.delete(memberAddressList);
        deliveryAddressRepository.delete(deliveryAddress);

    }

    @Override
    public void updateDeliveryAddress(Long deliveryAddressId, DeliveryAddressRequestDto requestDto) {

        DeliveryAddress deliveryAddress = deliveryAddressRepository.findDeliveryAddressById(deliveryAddressId);

        if (deliveryAddress == null) {
            throw new IllegalArgumentException("해당 배송지가 존재하지 않습니다.");
        }

        DeliveryAddress updateDeliveryAddress = requestDto.toEntity(requestDto);

        deliveryAddressRepository.save(updateDeliveryAddress);
        memberAddressListRepository.save(updateDeliveryAddress, memberUUID, deliveryAddressId); // uuid 설정 필요

    }

}