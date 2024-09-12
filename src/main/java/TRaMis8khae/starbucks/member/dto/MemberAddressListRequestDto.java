package TRaMis8khae.starbucks.member.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberAddressListRequestDto {
    private Long memberAddressId;
    private String memberUUID;
    private Long deliveryAddressId;
    private Boolean addressDefaultCheck;

    public MemberAddressListRequestDto toDto() {
        return MemberAddressListRequestDto.builder()
                .memberAddressId(memberAddressId)
                .memberUUID(memberUUID)
                .deliveryAddressId(deliveryAddressId)
                .addressDefaultCheck(addressDefaultCheck)
                .build();
    }

}
