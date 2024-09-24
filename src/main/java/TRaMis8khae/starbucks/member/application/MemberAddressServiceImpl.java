package TRaMis8khae.starbucks.member.application;

import TRaMis8khae.starbucks.common.jwt.JwtTokenProvider;
import TRaMis8khae.starbucks.member.dto.in.DeliveryAddressAddRequestDto;
import TRaMis8khae.starbucks.member.dto.out.DeliveryAddressResponseDto;
import TRaMis8khae.starbucks.member.dto.in.MemberAddressListAddRequestDto;
import TRaMis8khae.starbucks.member.dto.in.DeliveryAddressUpdateRequestDto;
import TRaMis8khae.starbucks.member.entity.DeliveryAddress;
import TRaMis8khae.starbucks.member.entity.MemberAddressList;
import TRaMis8khae.starbucks.member.infrastructure.DeliveryAddressRepository;
import TRaMis8khae.starbucks.member.infrastructure.MemberAddressListRepository;
import TRaMis8khae.starbucks.member.infrastructure.MemberAddressListRepositoryCustom;
import TRaMis8khae.starbucks.member.infrastructure.MemberRepository;
import TRaMis8khae.starbucks.member.vo.out.DeliveryAddressResponseVo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberAddressServiceImpl implements MemberAddressService {

    private final DeliveryAddressRepository deliveryAddressRepository;
    private final MemberAddressListRepository memberAddressListRepository;
    private final MemberAddressListRepositoryCustom memberAddressListRepositoryCustom;

    @Override
    @Transactional
    public void addDeliveryAddress(DeliveryAddressAddRequestDto deliveryAddressAddRequestDto) {

        DeliveryAddress addDeliveryAddress = deliveryAddressAddRequestDto.toEntity(deliveryAddressAddRequestDto);

        deliveryAddressRepository.save(addDeliveryAddress);

        MemberAddressList memberAddressList = MemberAddressListAddRequestDto
                .toEntity(deliveryAddressAddRequestDto, addDeliveryAddress);

        memberAddressListRepository.save(memberAddressList);

    }

    @Override
    public List<DeliveryAddressResponseDto> getMemberDeliveryAddress(String memberUUID) {

        List<DeliveryAddressResponseVo> deliveryAddressList = memberAddressListRepositoryCustom
                .findMemberAddressWithDeliveryAddress(memberUUID);

        if (deliveryAddressList.isEmpty()) {
            throw new IllegalArgumentException("해당 멤버의 배송지가 존재하지 않습니다.");
        }

        return deliveryAddressList.stream()
                .map(DeliveryAddressResponseDto::toDto)
                .toList();

    }

    @Override
    @Transactional
    public void deleteDeliveryAddress(Long deliveryAddressId) {

        DeliveryAddress deliveryAddress = deliveryAddressRepository.findDeliveryAddressById(deliveryAddressId);

        deliveryAddressRepository.delete(deliveryAddress);

    }

    @Override
    @Transactional
    public void updateDeliveryAddress(Long deliveryAddressId, DeliveryAddressUpdateRequestDto requestDto) {

        DeliveryAddress deliveryAddress = deliveryAddressRepository.findDeliveryAddressById(deliveryAddressId);

        if (deliveryAddress == null) {
            throw new IllegalArgumentException("해당 배송지가 존재하지 않습니다.");
        }

        DeliveryAddress updateDeliveryAddress = requestDto.toEntity(requestDto);

        deliveryAddressRepository.save(updateDeliveryAddress);

        MemberAddressList memberAddressList = memberAddressListRepository.findByDeliveryAddress(deliveryAddress);

        memberAddressList.updateAddressDefaultCheck(requestDto.isAddressDefaultCheck());

        memberAddressListRepository.save(memberAddressList);

    }

}