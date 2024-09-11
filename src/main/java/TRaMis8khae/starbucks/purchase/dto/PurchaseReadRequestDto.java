package TRaMis8khae.starbucks.purchase.dto;

import TRaMis8khae.starbucks.purchase.entity.Purchase;
import TRaMis8khae.starbucks.purchase.vo.PurchaseReadRequestVo;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PurchaseReadRequestDto {

    private String serialNum;

    public static PurchaseReadRequestDto toDto(PurchaseReadRequestVo vo) {
        return PurchaseReadRequestDto.builder()
                .serialNum(vo.getSerialNum())
                .build();
    }

    // Read에 관한 요청이기에 DB에 저장할 필요가 없음 -> toEntity() 메소드 필요 없음
//    public Purchase toEntity() {
//        return Purchase.builder()
//                .serialNumber(this.serialNum)
//                .build();
//    }

}