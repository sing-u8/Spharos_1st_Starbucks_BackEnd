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

}