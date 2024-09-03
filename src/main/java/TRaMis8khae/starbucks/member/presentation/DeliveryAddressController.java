package TRaMis8khae.starbucks.member.presentation;

import TRaMis8khae.starbucks.member.application.DeliveryAddressService;
import TRaMis8khae.starbucks.member.dto.DeliveryAddressDto;
import TRaMis8khae.starbucks.member.entity.DeliveryAddress;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/delivery")
public class DeliveryAddressController {
    private final DeliveryAddressService deliveryAddressService;

    @PostMapping("/{memberUUID}")
    public ResponseEntity<DeliveryAddress> addDeliveryAddress(@PathVariable String memberUUID, @RequestBody DeliveryAddressDto deliveryAddressDto) {
        DeliveryAddress deliveryAddress = deliveryAddressService.addDeliveryAddress(memberUUID, deliveryAddressDto);

        return ResponseEntity.ok(deliveryAddress);
    }


//    @PostMapping("/add-to-member")
//    public ResponseEntity<MemberAddress> addMemberAddress(@RequestBody MemberAddressDto memberAddressDto) {
//        MemberAddress addedMemberAddress = deliveryAddressService.addMemberAddress(memberAddressDto);
//        return ResponseEntity.ok(addedMemberAddress);
//    }
}
