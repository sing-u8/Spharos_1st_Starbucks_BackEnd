package TRaMis8khae.starbucks.voucher.dto.in;

import TRaMis8khae.starbucks.voucher.entity.Voucher;
import TRaMis8khae.starbucks.voucher.vo.in.VoucherAddRequestVo;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class VoucherAddRequestDto {

    private String name;

    private Double price;

    private String productUUID;

    private LocalDateTime expireDate;

    public static VoucherAddRequestDto toDto(VoucherAddRequestVo vo) {
        return VoucherAddRequestDto.builder()
                .name(vo.getName())
                .price(vo.getPrice())
                .productUUID(vo.getProductUUID())
                .expireDate(vo.getExpireDate())
                .build();
    }

    public Voucher toEntity(String voucherCode) {
        return Voucher.builder()
                .name(this.name)
                .price(this.price)
                .productUUID(this.productUUID)
                .expireDate(this.expireDate)
                .voucherCode(voucherCode)
                .build();
    }

}