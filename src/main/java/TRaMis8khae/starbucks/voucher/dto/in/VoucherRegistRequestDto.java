package TRaMis8khae.starbucks.voucher.dto.in;

import TRaMis8khae.starbucks.voucher.entity.MemberVoucherList;
import TRaMis8khae.starbucks.voucher.entity.Voucher;
import TRaMis8khae.starbucks.voucher.vo.in.VoucherRegistRequestVo;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class VoucherRegistRequestDto {

    private String memberUUID;

    private String voucherCode;

    public static VoucherRegistRequestDto toDto(VoucherRegistRequestVo vo, String memberUUID) {
        return VoucherRegistRequestDto.builder()
                .memberUUID(memberUUID)
                .voucherCode(vo.getVoucherCode())
                .build();
    }

    public MemberVoucherList toEntity(Voucher voucher, LocalDateTime registDate) {
        return MemberVoucherList.builder()
                .memberUUID(this.memberUUID)
                .registDate(registDate)
                .voucher(voucher)
                .build();
    }

}