package TRaMis8khae.starbucks.member.presentation;

import TRaMis8khae.starbucks.common.entity.CommonResponseEntity;
import TRaMis8khae.starbucks.common.entity.CommonResponseMessage;
import TRaMis8khae.starbucks.member.application.DeliveryAddressService;
import TRaMis8khae.starbucks.member.dto.DeliveryAddressResponseDto;
import TRaMis8khae.starbucks.member.vo.MemberAddressRequestVo;
import TRaMis8khae.starbucks.member.vo.MemberAddressResponseVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
public class MemberController {

    private final DeliveryAddressService deliveryAddressService;

    @PostMapping("delivery/{memberUUID}")
    public CommonResponseEntity<Void> addDeliveryAddress(@PathVariable String memberUUID, @RequestBody MemberAddressRequestVo memberAddressRequestVo) {

        deliveryAddressService.addDeliveryAddress(memberUUID, memberAddressRequestVo);

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                null);

    }

    @GetMapping("delivery/{memberUUID}")
    public CommonResponseEntity<List<MemberAddressResponseVo>> getMemberDeliveryAddress(@PathVariable String memberUUID) {
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
                        map(DeliveryAddressResponseDto::toResponseVo).
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
    public CommonResponseEntity<Void> updateDeliveryAddress(@PathVariable String memberUUID, @PathVariable Long memberAddressId, @RequestBody MemberAddressRequestVo memberAddressRequestVo) {

        deliveryAddressService.updateDeliveryAddress(memberUUID, memberAddressId, memberAddressRequestVo);

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                null);

    }

}