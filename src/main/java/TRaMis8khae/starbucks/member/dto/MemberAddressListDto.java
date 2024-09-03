package TRaMis8khae.starbucks.member.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberAddressListDto {
    private Long memberAddressId;
    private String memberUUID;
    private Long deliveryAddressId;
    private Boolean addressDefaultCheck;
}
