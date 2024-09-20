package TRaMis8khae.starbucks.event.dto;

import TRaMis8khae.starbucks.event.entity.Event;
import TRaMis8khae.starbucks.event.vo.EventRequestVo;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Builder
public class EventRequestDto {

    private String eventName;

    private Integer discountRate;

    private LocalDate startDate;

    private LocalDate endDate;

    public static EventRequestDto toDto(EventRequestVo requestVo) {
        return EventRequestDto.builder()
                .eventName(requestVo.getEventName())
                .discountRate(requestVo.getDiscountRate())
                .startDate(requestVo.getStartDate())
                .endDate(requestVo.getEndDate())
                .build();
    }

    public Event toEntity(EventRequestDto requestDto) {
        return Event.builder()
                .eventName(requestDto.getEventName())
                .discountRate(requestDto.getDiscountRate())
                .startDate(requestDto.getStartDate())
                .endDate(requestDto.getEndDate())
                .build();
    }

}
