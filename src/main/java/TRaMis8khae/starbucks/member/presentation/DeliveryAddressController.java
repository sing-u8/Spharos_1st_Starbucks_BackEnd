package TRaMis8khae.starbucks.member.presentation;

import TRaMis8khae.starbucks.common.entity.CommonResponseEntity;
import TRaMis8khae.starbucks.common.entity.CommonResponseMessage;
import TRaMis8khae.starbucks.member.application.DeliveryAddressService;
import TRaMis8khae.starbucks.member.dto.DeliveryAddressResponseDto;
import TRaMis8khae.starbucks.member.entity.DeliveryAddress;
import TRaMis8khae.starbucks.member.entity.MemberAddressList;
import TRaMis8khae.starbucks.member.vo.MemberAddressResponseVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/delivery")
public class DeliveryAddressController {
    private final DeliveryAddressService deliveryAddressService;

    @PostMapping("/{memberUUID}")
    public ResponseEntity<DeliveryAddress> addDeliveryAddress(@PathVariable String memberUUID, @RequestBody DeliveryAddressResponseDto deliveryAddressResponseDto) {
        DeliveryAddress deliveryAddress = deliveryAddressService.addDeliveryAddress(memberUUID, deliveryAddressResponseDto);
        return ResponseEntity.ok(deliveryAddress);
    }

    @GetMapping("/{memberUUID}")
    public ResponseEntity<CommonResponseEntity<List<MemberAddressResponseVo>>> getMemberAddress(@PathVariable String memberUUID) {
        List<MemberAddressResponseVo> memberAddressList = deliveryAddressService.getMemberAddress(memberUUID);

        CommonResponseEntity<List<MemberAddressResponseVo>> response = new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                memberAddressList);

        return ResponseEntity.ok(response);
    }
}
