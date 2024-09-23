package TRaMis8khae.starbucks.auth.dto;

import TRaMis8khae.starbucks.auth.vo.ResetPasswordRequestVo;
import TRaMis8khae.starbucks.member.entity.Member;
import lombok.*;

@Getter
@ToString
@NoArgsConstructor
public class ResetPasswordRequestDto {

    private String password;

    @Builder
    public ResetPasswordRequestDto(String password) {
        this.password = password;
    }

    public static ResetPasswordRequestDto toDto(ResetPasswordRequestVo resetPasswordRequestVo) {
        return ResetPasswordRequestDto.builder()
                .password(resetPasswordRequestVo.getLoginId())
                .build();
    }

    public Member toEntity(Member member) {
        return Member.builder()
                .id(member.getId())
                .email(member.getEmail())
                .name(member.getName())
                .memberStatus(member.getMemberStatus())
                .loginId(member.getLoginId())
                .memberUUID(member.getMemberUUID())
                .birth(member.getBirth())
                .address(member.getAddress())
                .paymentPassword(member.getPaymentPassword())
                .nickname(member.getNickname())
                .phoneNumber(member.getPhoneNumber())
                .password(this.password)
                .build();
    }

}
