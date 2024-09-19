package TRaMis8khae.starbucks.event.application;

import TRaMis8khae.starbucks.event.dto.EventInfoResponseDto;
import TRaMis8khae.starbucks.event.dto.EventProductResponseDto;
import TRaMis8khae.starbucks.event.infrastructure.EventInfoRepository;
import TRaMis8khae.starbucks.event.infrastructure.EventProductRepository;
import TRaMis8khae.starbucks.event.infrastructure.ProductEventListRepository;
import TRaMis8khae.starbucks.product.entity.Product;
import TRaMis8khae.starbucks.product.infrastructure.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class EventInfoServiceImpl implements EventInfoService {

    private final EventInfoRepository eventInfoRepository;
    private final EventProductRepository eventProductRepository;
    private final ProductEventListRepository productEventListRepository;
    private final ProductRepository productRepository;

    @Override
    public List<EventInfoResponseDto> getEventList(Long eventId) {

        return eventInfoRepository.findAll().stream()
                .map(EventInfoResponseDto::toDto)
                .toList();

    }


//    @Override
//    public List<EventProductResponseDto> getEventProductList(String productUUID) {
//
//        return eventProductRepository.findByProductUUID(productUUID)
//                .stream().map(EventProductResponseDto::toDto).toList();
//
//    }

//    @Override
//    public Slice<EventProductResponseDto> getEventProductList(List<String> productUUID) {
//
//        return eventProductRepository.findByProductUUID(productUUID, PageRequest.of(0, 10))
//                .map(EventProductResponseDto::toDto);
//
//    }

    @Override
    public List<String> getEventUUID(Long eventId) {

       return productEventListRepository.findByEventId(eventId).stream()
               .map(productEventList -> productEventList.getProductUUID())
               .collect(Collectors.toList());

    }

}