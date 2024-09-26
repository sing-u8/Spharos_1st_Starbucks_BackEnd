package TRaMis8khae.starbucks.event.dto.out;

import TRaMis8khae.starbucks.event.entity.Event;
import TRaMis8khae.starbucks.event.vo.out.EventResponseVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
@ToString
@AllArgsConstructor
public class EventInfoResponseDto {

    private String eventName;
    private Integer discountRate;
    private LocalDate startDate;
    private LocalDate endDate;

    private List<String> eventImage;

    public static EventInfoResponseDto toDto(Event event) {
        return EventInfoResponseDto.builder()
                .eventName(event.getEventName())
                .discountRate(event.getDiscountRate())
                .startDate(event.getStartDate())
                .endDate(event.getEndDate())
                .build();
    }

    public EventResponseVo toVo() {
        return EventResponseVo.builder()
                .eventName(this.eventName)
                .discountRate(this.discountRate)
                .startDate(this.startDate)
                .endDate(this.endDate)
                .build();
    }

    public static EventInfoResponseDto fromEntity(Event event, List<String> eventImage) {
        return EventInfoResponseDto.builder()
                .eventName(event.getEventName())
                .discountRate(event.getDiscountRate())
                .startDate(event.getStartDate())
                .endDate(event.getEndDate())
                .eventImage(eventImage)
                .build();
    }
}
