package TRaMis8khae.starbucks.vendor.application;


import TRaMis8khae.starbucks.vendor.dto.in.VolumeRequestDto;
import TRaMis8khae.starbucks.vendor.dto.out.VolumeResponseDto;


public interface VolumeService {

	void addVolume(VolumeRequestDto requestDto);

	VolumeResponseDto findVolume(String productUUID);

}
