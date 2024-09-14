package TRaMis8khae.starbucks.member.presentation;

import TRaMis8khae.starbucks.common.entity.CommonResponseEntity;
import TRaMis8khae.starbucks.common.entity.CommonResponseMessage;
import TRaMis8khae.starbucks.member.application.MemberAddressService;
import TRaMis8khae.starbucks.member.application.MemberService;
import TRaMis8khae.starbucks.member.dto.AddTermsConsentListRequestDto;
import TRaMis8khae.starbucks.member.dto.DeliveryAddressRequestDto;
import TRaMis8khae.starbucks.member.dto.DeliveryAddressResponseDto;
import TRaMis8khae.starbucks.member.vo.AddTermsConsentListRequestVo;
import TRaMis8khae.starbucks.member.vo.DeliveryAddressRequestVo;
import TRaMis8khae.starbucks.member.vo.DeliveryAddressResponseVo;
import TRaMis8khae.starbucks.member.vo.TermsConsentListRequestVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
public class MemberController {

    private final MemberAddressService memberAddressService;
    private final MemberService memberService;

    @PostMapping("delivery/{memberUUID}")
    public CommonResponseEntity<Void> addDeliveryAddress(
            @PathVariable String memberUUID,
            @RequestBody DeliveryAddressRequestVo deliveryAddressRequestVo) {

        DeliveryAddressRequestDto deliveryAddressRequestDto = DeliveryAddressRequestDto.toDto(deliveryAddressRequestVo);

        memberAddressService.addDeliveryAddress(memberUUID, deliveryAddressRequestDto);

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                null);
    }

    @GetMapping("delivery/{memberUUID}")
    public CommonResponseEntity<List<DeliveryAddressResponseVo>> getMemberDeliveryAddress(
            @PathVariable String memberUUID) {

        List<DeliveryAddressResponseDto> memberAddressList = memberAddressService.getMemberDeliveryAddress(memberUUID);

        if (memberAddressList.isEmpty()) {
            return new CommonResponseEntity<>(
                    HttpStatus.OK,
                    true,
                    "배송지가 없습니다.",
                    null);
        }

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                memberAddressList.stream().
                        map(DeliveryAddressResponseDto::toVo).
                        toList());
    }

    @DeleteMapping("delivery/{deliveryAddressId}")
    public CommonResponseEntity<Void> deleteDeliveryAddress(@PathVariable Long deliveryAddressId) {

        memberAddressService.deleteDeliveryAddress(deliveryAddressId);



        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                null);
    }

//    @PutMapping("delivery/{deliveryAddressId}")
//    public CommonResponseEntity<Void> updateDeliveryAddress(
//            @PathVariable Long deliveryAddressId,
//            @RequestBody UpdateDeliveryAddressRequestVo requestVo) {
//
//        UpdateDeliveryAddressRequestDto requestDto = UpdateDeliveryAddressRequestDto.toDto(requestVo);
//
//        memberAddressService.updateDeliveryAddress(deliveryAddressId, deliveryAddressRequestDto);
//
//        return new CommonResponseEntity<>(
//                HttpStatus.OK,
//                true,
//                CommonResponseMessage.SUCCESS.getMessage(),
//                null);
//    }



    @PostMapping("/terms")
    public CommonResponseEntity<Void> addTerms(@RequestBody AddTermsConsentListRequestVo requestVo) {

        AddTermsConsentListRequestDto requestDto = AddTermsConsentListRequestDto.toDto(requestVo);

        memberService.addTerms(requestDto);

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                null);
    }

}