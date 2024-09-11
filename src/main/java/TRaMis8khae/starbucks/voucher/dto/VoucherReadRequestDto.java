package TRaMis8khae.starbucks.voucher.dto;

import TRaMis8khae.starbucks.voucher.entity.MemberVoucherList;
import TRaMis8khae.starbucks.voucher.vo.VoucherReadRequestVo;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class VoucherReadRequestDto {

    private String memberUUID;

    public static VoucherReadRequestDto toDto(VoucherReadRequestVo vo) {
        return VoucherReadRequestDto.builder()
                .memberUUID(vo.getMemberUUID())
                .build();
    }

    public static MemberVoucherList toEntity(VoucherReadRequestDto dto) {
        return MemberVoucherList.builder()
                .memberUUID(dto.getMemberUUID())
                .build();
    }

}