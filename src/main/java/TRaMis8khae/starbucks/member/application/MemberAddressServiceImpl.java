package TRaMis8khae.starbucks.member.application;

import TRaMis8khae.starbucks.common.jwt.JwtTokenProvider;
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
import io.jsonwebtoken.Claims;
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
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public void addDeliveryAddress(DeliveryAddressRequestDto deliveryAddressRequestDto) {

        DeliveryAddress addDeliveryAddress = deliveryAddressRequestDto.toEntity(deliveryAddressRequestDto);

        deliveryAddressRepository.save(addDeliveryAddress);

        MemberAddressList memberAddressList = MemberAddressListRequestDto
                .toEntity(deliveryAddressRequestDto, addDeliveryAddress);

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
    public void updateDeliveryAddress(Long deliveryAddressId, String accessToken, UpdateDeliveryAddressRequestDto requestDto) {

        DeliveryAddress deliveryAddress = deliveryAddressRepository.findDeliveryAddressById(deliveryAddressId);

        if (deliveryAddress == null) {
            throw new IllegalArgumentException("해당 배송지가 존재하지 않습니다.");
        }

        Claims claims = jwtTokenProvider.getClaims(accessToken);

        String memberUuidFromToken = claims.get("memberUUID", String.class);

        DeliveryAddress updateDeliveryAddress = requestDto.toEntity(requestDto);

        deliveryAddressRepository.save(updateDeliveryAddress);
//        memberAddressListRepository.save(updateDeliveryAddress, memberUuidFromToken, deliveryAddressId); // uuid 설정 필요

    }

}