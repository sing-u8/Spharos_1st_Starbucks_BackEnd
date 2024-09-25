package TRaMis8khae.starbucks.voucher.presentation;

import TRaMis8khae.starbucks.common.entity.BaseResponse;
import TRaMis8khae.starbucks.common.entity.BaseResponseStatus;
import TRaMis8khae.starbucks.voucher.application.VoucherService;
import TRaMis8khae.starbucks.voucher.dto.in.VoucherAddRequestDto;
import TRaMis8khae.starbucks.voucher.dto.in.VoucherRegistRequestDto;
import TRaMis8khae.starbucks.voucher.dto.out.VoucherReadResponseDto;
import TRaMis8khae.starbucks.voucher.vo.in.VoucherAddRequestVo;
import TRaMis8khae.starbucks.voucher.vo.in.VoucherRegistRequestVo;
import TRaMis8khae.starbucks.voucher.vo.out.VoucherReadResponseVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/voucher")
public class VoucherController {

    private final VoucherService voucherService;

    // 상품권 추가 (관리자)
    @PostMapping("/add")
    public BaseResponse<Void> addVoucher(@RequestBody List<VoucherAddRequestVo> requestVos) {

        List<VoucherAddRequestDto> requestDtos = new ArrayList<>();

        for (VoucherAddRequestVo requestVo : requestVos) {
            VoucherAddRequestDto requestDto = VoucherAddRequestDto.toDto(requestVo);
            requestDtos.add(requestDto);
        }

        voucherService.addVoucher(requestDtos);

        return new BaseResponse<>(
                BaseResponseStatus.SUCCESS
        );
    }

    // 상품권 등록 (사용자)
    @PostMapping("/regist")
    public BaseResponse<Void> registVoucher(
            @RequestBody VoucherRegistRequestVo vo,
            Authentication authentication) {

        String memberUUID = authentication.getName();

        VoucherRegistRequestDto requestDto = VoucherRegistRequestDto.toDto(vo, memberUUID);

        voucherService.registVoucher(requestDto);

        return new BaseResponse<>(
                BaseResponseStatus.SUCCESS
        );
    }

    // todo 상품권 사용 API

    // 상품권 조회 (사용자)
    @GetMapping("/find")
    public BaseResponse<Slice<VoucherReadResponseVo>> findVouchers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            Authentication authentication) {

        Pageable pageable = PageRequest.of(page, size);
        String memberUUID = authentication.getName();

        return new BaseResponse<>(
                voucherService.findVouchers(pageable, memberUUID).map(VoucherReadResponseDto::toVo)
        );
    }

    // todo 상품권 사용

    // 상품권 삭제 (관리자, 사용자 중 정해야 함)
    @DeleteMapping("/delete/{id}")
    public BaseResponse<Void> deleteVoucher(@PathVariable Long id) {

        voucherService.deleteVoucher(id);

        return new BaseResponse<>(
                BaseResponseStatus.SUCCESS
        );
    }

}