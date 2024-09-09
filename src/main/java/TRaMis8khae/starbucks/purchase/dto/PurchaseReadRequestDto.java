package TRaMis8khae.starbucks.purchase.dto;

import TRaMis8khae.starbucks.purchase.entity.Purchase;
import TRaMis8khae.starbucks.purchase.vo.PurchaseReadRequestVo;
import TRaMis8khae.starbucks.purchase.vo.PurchaseReadResponseVo;
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

    public static Purchase toEntity(PurchaseReadRequestDto dto) {
        return Purchase.builder()
                .serialNumber(dto.getSerialNum())
                .build();
    }

}