package TRaMis8khae.starbucks.product.application;


import TRaMis8khae.starbucks.product.dto.VolumeResponseDto;


public interface VolumeService {

	VolumeResponseDto findVolume(String productUUID);

}
