package TRaMis8khae.starbucks.auth.dto;

import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FindMemberRequestDto {

    private String name;

    private String phoneNumber;

}
