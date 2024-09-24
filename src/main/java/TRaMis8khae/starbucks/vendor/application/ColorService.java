package TRaMis8khae.starbucks.vendor.application;


import TRaMis8khae.starbucks.vendor.dto.in.ColorRequestDto;
import TRaMis8khae.starbucks.vendor.dto.out.ColorResponseDto;


public interface ColorService {

	void addColor(ColorRequestDto requestDto);

	ColorResponseDto findColor(String productUUID);

}
