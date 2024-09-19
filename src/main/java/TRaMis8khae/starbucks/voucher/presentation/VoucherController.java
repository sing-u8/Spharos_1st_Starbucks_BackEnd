package TRaMis8khae.starbucks.voucher.presentation;

import TRaMis8khae.starbucks.common.entity.BaseResponse;
import TRaMis8khae.starbucks.common.entity.BaseResponseStatus;
import TRaMis8khae.starbucks.voucher.application.VoucherService;
import TRaMis8khae.starbucks.voucher.dto.*;
import TRaMis8khae.starbucks.voucher.vo.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    public BaseResponse<List<VoucherAddResponseVo>> addVoucher(
            @RequestBody List<VoucherAddRequestVo> requestVos) {

        List<VoucherAddRequestDto> requestDtos = new ArrayList<>();
        for (VoucherAddRequestVo requestVo : requestVos) {
            VoucherAddRequestDto requestDto = VoucherAddRequestDto.toDto(requestVo);
            requestDtos.add(requestDto);
        }

        return new BaseResponse<>(
                voucherService.addVoucher(requestDtos).stream().map(VoucherAddResponseDto::toVo).toList()
        );
    }

    // 상품권 등록 (사용자)
    @PostMapping("/regist")
    public BaseResponse<Void> registVoucher(@RequestBody VoucherRegistRequestVo vo) {

        VoucherRegistRequestDto requestDto = VoucherRegistRequestDto.toDto(vo);

        voucherService.registVoucher(requestDto);

        return new BaseResponse<>(
                BaseResponseStatus.SUCCESS
        );
    }

    // todo 상품권 사용 API

    // 상품권 조회 (사용자)
    @GetMapping("/find/{memberUUID}")
    public BaseResponse<List<VoucherReadResponseVo>> findVouchers(@PathVariable String memberUUID) {

        return new BaseResponse<>(
                voucherService.findVouchers(memberUUID).stream().map(VoucherReadResponseDto::toVo).toList()
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