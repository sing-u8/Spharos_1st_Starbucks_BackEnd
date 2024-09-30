package TRaMis8khae.starbucks.event.dto.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@AllArgsConstructor
public class EventProductListRequestDto {

    private String productUUID;

}
