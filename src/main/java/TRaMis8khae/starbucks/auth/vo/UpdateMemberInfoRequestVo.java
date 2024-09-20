package TRaMis8khae.starbucks.auth.vo;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateMemberInfoRequestVo {

    private String nickname;
    private String phoneNumber;


}