package TRaMis8khae.starbucks.member.presentation;

import TRaMis8khae.starbucks.common.entity.CommonResponseEntity;
import TRaMis8khae.starbucks.common.entity.CommonResponseMessage;
import TRaMis8khae.starbucks.member.application.DeliveryAddressService;
import TRaMis8khae.starbucks.member.dto.DeliveryAddressRequestDto;
import TRaMis8khae.starbucks.member.dto.DeliveryAddressResponseDto;
import TRaMis8khae.starbucks.member.vo.MemberDeliveryAddressRequestVo;
import TRaMis8khae.starbucks.member.vo.MemberDeliveryAddressResponseVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
public class MemberController {

    private final DeliveryAddressService deliveryAddressService;

    @PostMapping("delivery/{memberUUID}")
    public CommonResponseEntity<Void> addDeliveryAddress(@PathVariable String memberUUID, @RequestBody MemberDeliveryAddressRequestVo memberDeliveryAddressRequestVo) {

        DeliveryAddressRequestDto deliveryAddressRequestDto = DeliveryAddressRequestDto.toDto(memberDeliveryAddressRequestVo);

        deliveryAddressService.addDeliveryAddress(memberUUID, deliveryAddressRequestDto);

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                null);

    }

    @GetMapping("delivery/{memberUUID}")
    public CommonResponseEntity<List<MemberDeliveryAddressResponseVo>> getMemberDeliveryAddress(@PathVariable String memberUUID) {
        List<DeliveryAddressResponseDto> memberAddressList = deliveryAddressService.getMemberDeliveryAddress(memberUUID);

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

    @DeleteMapping("delivery/{memberAddressId}")
    public CommonResponseEntity<Void> deleteDeliveryAddress(@PathVariable Long memberAddressId) {
        deliveryAddressService.deleteDeliveryAddress(memberAddressId);
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                null);
    }

    @PutMapping("delivery/{memberUUID}/{memberAddressId}")
    public CommonResponseEntity<Void> updateDeliveryAddress(@PathVariable String memberUUID, @PathVariable Long memberAddressId, @RequestBody MemberDeliveryAddressRequestVo memberDeliveryAddressRequestVo) {

        deliveryAddressService.updateDeliveryAddress(memberUUID, memberAddressId, memberDeliveryAddressRequestVo);

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                null);

    }

}