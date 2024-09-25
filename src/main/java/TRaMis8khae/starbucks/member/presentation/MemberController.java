package TRaMis8khae.starbucks.member.presentation;

import TRaMis8khae.starbucks.common.entity.BaseResponse;
import TRaMis8khae.starbucks.common.entity.BaseResponseStatus;
import TRaMis8khae.starbucks.member.application.MemberAddressService;
import TRaMis8khae.starbucks.member.dto.in.DeliveryAddressAddRequestDto;
import TRaMis8khae.starbucks.member.dto.out.DeliveryAddressResponseDto;
import TRaMis8khae.starbucks.member.dto.in.DeliveryAddressUpdateRequestDto;
import TRaMis8khae.starbucks.member.infrastructure.DeliveryAddressRepository;
import TRaMis8khae.starbucks.member.infrastructure.MemberAddressListRepository;
import TRaMis8khae.starbucks.member.vo.in.DeliveryAddressRequestVo;
import TRaMis8khae.starbucks.member.vo.out.DeliveryAddressResponseVo;
import TRaMis8khae.starbucks.member.vo.in.UpdateDeliveryAddressRequestVo;
import TRaMis8khae.starbucks.member.application.MemberService;
import TRaMis8khae.starbucks.member.dto.*;
import TRaMis8khae.starbucks.member.vo.in.DeliveryAddressRequestVo;
import TRaMis8khae.starbucks.member.vo.out.DeliveryAddressResponseVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
public class MemberController {

    private final MemberAddressService memberAddressService;
    private final MemberAddressListRepository memberAddressListRepository;

    @PostMapping("delivery")
    public BaseResponse<Void> addDeliveryAddress(
            Authentication authentication,
            @RequestBody DeliveryAddressRequestVo deliveryAddressRequestVo) {

        DeliveryAddressAddRequestDto deliveryAddressAddRequestDto = DeliveryAddressAddRequestDto
                .toDto(deliveryAddressRequestVo, authentication.getName());

        memberAddressService.addDeliveryAddress(deliveryAddressAddRequestDto);

        return new BaseResponse<>(BaseResponseStatus.SUCCESS);

    }

    @GetMapping("delivery")
    public BaseResponse<List<DeliveryAddressResponseVo>> getMemberDeliveryAddress(Authentication authentication) {

        List<DeliveryAddressResponseDto> memberAddressList = memberAddressService
                .getMemberDeliveryAddress(authentication.getName());

        return new BaseResponse<>(
                memberAddressList.stream().map(DeliveryAddressResponseDto::toVo).toList()
        );

    }

    @DeleteMapping("delivery/{deliveryAddressId}")
    public BaseResponse<Void> deleteDeliveryAddress(@PathVariable Long deliveryAddressId,
                                                    Authentication authentication) {

        memberAddressListRepository.findByMemberUUIDAndDeliveryAddressId(authentication.getName(), deliveryAddressId)
                .orElseThrow(() -> new IllegalArgumentException("해당 멤버의 배송지가 존재하지 않습니다."));

        memberAddressService.deleteDeliveryAddress(deliveryAddressId);

        return new BaseResponse<>(BaseResponseStatus.SUCCESS);

    }

    @PutMapping("delivery/{deliveryAddressId}")
    public BaseResponse<Void> updateDeliveryAddress(
            @PathVariable Long deliveryAddressId,
            Authentication authentication,
            @RequestBody UpdateDeliveryAddressRequestVo requestVo) {

        DeliveryAddressUpdateRequestDto requestDto = DeliveryAddressUpdateRequestDto.toDto(requestVo, authentication.getName());

        memberAddressService.updateDeliveryAddress(deliveryAddressId, requestDto);

        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }

}