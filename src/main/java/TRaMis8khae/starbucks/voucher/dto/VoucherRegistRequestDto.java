package TRaMis8khae.starbucks.voucher.dto;

import TRaMis8khae.starbucks.voucher.entity.MemberVoucherList;
import TRaMis8khae.starbucks.voucher.entity.Voucher;
import TRaMis8khae.starbucks.voucher.vo.VoucherRegistRequestVo;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class VoucherRegistRequestDto {

    private String memberUUID;

    private String voucherCode;

    public static VoucherRegistRequestDto toDto(VoucherRegistRequestVo vo) {
        return VoucherRegistRequestDto.builder()
                .memberUUID(vo.getMemberUUID())
                .voucherCode(vo.getVoucherCode())
                .build();
    }

    public static MemberVoucherList toEntity(VoucherRegistRequestDto dto, Voucher voucher, LocalDateTime registDate) {
        return MemberVoucherList.builder()
                .memberUUID(dto.memberUUID)
                .registDate(registDate)
                .voucher(voucher)
                .build();
    }

}