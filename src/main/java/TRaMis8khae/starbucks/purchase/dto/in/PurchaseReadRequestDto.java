package TRaMis8khae.starbucks.purchase.dto.in;

import TRaMis8khae.starbucks.purchase.vo.in.PurchaseReadRequestVo;
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