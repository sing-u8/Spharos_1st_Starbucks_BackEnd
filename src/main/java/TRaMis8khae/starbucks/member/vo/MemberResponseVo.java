package TRaMis8khae.starbucks.member.vo;

import lombok.*;

import java.util.Date;
import java.util.UUID;

@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberResponseVo {

    private Long memberId;

    private String memberUUID;

    private String name;

    private String loginId;

    private String password;

    private Date birth;

    private String phoneNumber;

    private String email;

    private String nickname;

    private String address;

    private String paymentPassword;

    private Boolean memberStatus;

}