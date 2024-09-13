package TRaMis8khae.starbucks.voucher.dto;

import TRaMis8khae.starbucks.voucher.entity.MemberVoucherList;
import TRaMis8khae.starbucks.voucher.vo.VoucherReadResponseVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VoucherReadResponseDto {

    private String memberUUID;

    private LocalDateTime registDate;

    private String name;

    private Double price;

    private String productUUID;

    private LocalDateTime expireDate;

    private String voucherCode;

    public static VoucherReadResponseDto toDto(MemberVoucherList memberVoucherList) {
        return VoucherReadResponseDto.builder()
                .memberUUID(memberVoucherList.getMemberUUID())
                .registDate(memberVoucherList.getRegistDate())
                .name(memberVoucherList.getVoucher().getName())
                .price(memberVoucherList.getVoucher().getPrice())
                .productUUID(memberVoucherList.getVoucher().getProductUUID())
                .expireDate(memberVoucherList.getVoucher().getExpireDate())
                .voucherCode(memberVoucherList.getVoucher().getVoucherCode())
                .build();
    }

    public VoucherReadResponseVo toVo() {
        return VoucherReadResponseVo.builder()
                .memberUUID(this.memberUUID)
                .registDate(this.registDate)
                .name(this.name)
                .price(this.price)
                .productUUID(this.productUUID)
                .expireDate(this.expireDate)
                .voucherCode(this.voucherCode)
                .build();
    }

}