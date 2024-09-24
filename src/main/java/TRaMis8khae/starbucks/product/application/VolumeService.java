package TRaMis8khae.starbucks.product.application;


import TRaMis8khae.starbucks.product.dto.in.VolumeRequestDto;
import TRaMis8khae.starbucks.product.dto.out.VolumeResponseDto;


public interface VolumeService {

	void addVolume(VolumeRequestDto requestDto);

	VolumeResponseDto findVolume(String productUUID);

}
