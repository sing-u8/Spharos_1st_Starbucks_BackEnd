package TRaMis8khae.starbucks.event.dto;

import TRaMis8khae.starbucks.event.entity.Event;
import TRaMis8khae.starbucks.event.vo.EventInfoResponseVo;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class EventInfoResponseDto {

    private String eventName;
    private Integer discountRate;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public static EventInfoResponseDto toDto(Event event) {
        return EventInfoResponseDto.builder()
                .eventName(event.getEventName())
                .discountRate(event.getDiscountRate())
                .startDate(event.getStartDate())
                .endDate(event.getEndDate())
                .build();
    }

    public EventInfoResponseVo toVo() {
        return EventInfoResponseVo.builder()
                .eventName(this.eventName)
                .discountRate(this.discountRate)
                .startDate(this.startDate)
                .endDate(this.endDate)
                .build();
    }
}
