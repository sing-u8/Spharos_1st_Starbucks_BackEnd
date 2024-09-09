package TRaMis8khae.starbucks.purchase.dto;

import TRaMis8khae.starbucks.purchase.vo.PurchaseDeleteRequestVo;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PurchaseDeleteRequestDto {

    private String serialNum;

    public static PurchaseDeleteRequestDto toDto(PurchaseDeleteRequestVo vo) {
        return PurchaseDeleteRequestDto.builder()
                .serialNum(vo.getSerialNum())
                .build();
    }

}