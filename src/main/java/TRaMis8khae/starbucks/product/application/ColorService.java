package TRaMis8khae.starbucks.product.application;


import TRaMis8khae.starbucks.product.dto.ColorResponseDto;


public interface ColorService {

	ColorResponseDto findColor(String productUUID);

}
