package TRaMis8khae.starbucks.event.vo;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Getter
@Builder
@ToString
public class EventRequestVo {

    private String eventName;

    private Integer discountRate;

    private LocalDate startDate;

    private LocalDate endDate;

    private MultipartFile image;

}
