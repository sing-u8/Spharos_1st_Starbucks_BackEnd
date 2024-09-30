package TRaMis8khae.starbucks.event.application;

import TRaMis8khae.starbucks.event.dto.in.EventMediaRequestDto;
import TRaMis8khae.starbucks.event.dto.in.EventRequestDto;
import TRaMis8khae.starbucks.event.dto.in.ProductEventListRequestDto;

public interface EventCrawlingService {

    void addCrawlEvent(EventRequestDto requestDto);
    void addCrawlEventProduct(ProductEventListRequestDto requestDto);
    void addCrawlEventMedia(EventMediaRequestDto requestDto);

}
