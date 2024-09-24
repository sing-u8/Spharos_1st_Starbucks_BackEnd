package TRaMis8khae.starbucks.member.presentation;

import TRaMis8khae.starbucks.common.entity.BaseResponse;
import TRaMis8khae.starbucks.common.entity.BaseResponseStatus;
import TRaMis8khae.starbucks.member.application.MemberAddressService;
import TRaMis8khae.starbucks.member.application.MemberService;
import TRaMis8khae.starbucks.member.dto.*;
import TRaMis8khae.starbucks.member.vo.in.DeliveryAddressRequestVo;
import TRaMis8khae.starbucks.member.vo.out.DeliveryAddressResponseVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
public class MemberController {

    private final MemberAddressService memberAddressService;
    private final MemberService memberService;

    @PostMapping("delivery/{memberUUID}")
    public BaseResponse<Void> addDeliveryAddress(
            @PathVariable String memberUUID,
            @RequestBody DeliveryAddressRequestVo deliveryAddressRequestVo) {

        DeliveryAddressRequestDto deliveryAddressRequestDto = DeliveryAddressRequestDto.toDto(deliveryAddressRequestVo);

        memberAddressService.addDeliveryAddress(memberUUID, deliveryAddressRequestDto);

        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }

    @GetMapping("delivery/{memberUUID}")
    public BaseResponse<List<DeliveryAddressResponseVo>> getMemberDeliveryAddress(
            @PathVariable String memberUUID) {

        List<DeliveryAddressResponseDto> memberAddressList = memberAddressService.getMemberDeliveryAddress(memberUUID);

        List<DeliveryAddressResponseVo> responseVos = memberAddressList
                .stream().map(DeliveryAddressResponseDto::toVo).toList();

        return new BaseResponse<>(
                responseVos
        );
    }

    @DeleteMapping("delivery/{deliveryAddressId}")
    public BaseResponse<Void> deleteDeliveryAddress(@PathVariable Long deliveryAddressId) {

        memberAddressService.deleteDeliveryAddress(deliveryAddressId);

        return new BaseResponse<>(
                BaseResponseStatus.SUCCESS
        );

    }



}