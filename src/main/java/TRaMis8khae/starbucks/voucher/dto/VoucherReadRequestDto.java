package TRaMis8khae.starbucks.voucher.dto;

import TRaMis8khae.starbucks.voucher.entity.MemberVoucherList;
import TRaMis8khae.starbucks.voucher.vo.VoucherReadRequestVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class VoucherReadRequestDto {

    private String memberUUID;

    public static VoucherReadRequestDto toDto(VoucherReadRequestVo vo) {
        return VoucherReadRequestDto.builder()
                .memberUUID(vo.getMemberUUID())
                .build();
    }

    public MemberVoucherList toEntity() {
        return MemberVoucherList.builder()
                .memberUUID(this.memberUUID)
                .build();
    }

}