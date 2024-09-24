package TRaMis8khae.starbucks.product.application;


import TRaMis8khae.starbucks.product.dto.in.ColorRequestDto;
import TRaMis8khae.starbucks.product.dto.out.ColorResponseDto;


public interface ColorService {

	void addColor(ColorRequestDto requestDto);

	ColorResponseDto findColor(String productUUID);

}
