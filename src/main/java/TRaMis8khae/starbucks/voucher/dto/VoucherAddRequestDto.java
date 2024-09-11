package TRaMis8khae.starbucks.voucher.dto;

import TRaMis8khae.starbucks.voucher.entity.Voucher;
import TRaMis8khae.starbucks.voucher.vo.VoucherAddRequestVo;
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
                .name(name)
                .price(dto.getPrice())
                .productUUID(dto.getProductUUID())
                .expireDate(dto.getExpireDate())
                .voucherCode(voucherCode)
                .build();
    }

}