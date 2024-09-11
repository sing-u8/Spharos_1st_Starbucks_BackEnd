package TRaMis8khae.starbucks.voucher.presentation;

import TRaMis8khae.starbucks.common.entity.CommonResponseEntity;
import TRaMis8khae.starbucks.voucher.application.VoucherService;
import TRaMis8khae.starbucks.voucher.dto.*;
import TRaMis8khae.starbucks.voucher.vo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/voucher")
public class VoucherController {

    private final VoucherService voucherService;

    // 상품권 추가 (관리자)
    @PostMapping("/add")
    public CommonResponseEntity<List<VoucherAddResponseVo>> addVoucher(
            @RequestBody List<VoucherAddRequestVo> requestVos) {

        List<VoucherAddRequestDto> requestDtos = new ArrayList<>();
        for (VoucherAddRequestVo requestVo : requestVos) {
            VoucherAddRequestDto requestDto = VoucherAddRequestDto.toDto(requestVo);
            requestDtos.add(requestDto);
        }

        List<VoucherAddResponseDto> responseDtos = voucherService.addVoucher(requestDtos);

        List<VoucherAddResponseVo> responseVos = responseDtos.stream().map(VoucherAddResponseDto::toVo).toList();

        return new CommonResponseEntity<>(
                HttpStatus.ACCEPTED,
                true,
                "상품권 추가 성공",
                responseVos
        );
    }

    // 상품권 등록 (사용자)
    @PostMapping("/regist")
    public CommonResponseEntity<Void> registVoucher(@RequestBody VoucherRegistRequestVo vo) {

        VoucherRegistRequestDto requestDto = VoucherRegistRequestDto.toDto(vo);

        voucherService.registVoucher(requestDto);

        return new CommonResponseEntity<>(
                HttpStatus.ACCEPTED,
                true,
                "상품권 등록 성공",
                null
        );
    }

    // 상품권 조회 (사용자)
    @GetMapping("/find")
    public CommonResponseEntity<List<VoucherReadResponseVo>> findVouchers(VoucherReadRequestVo vo) {

        VoucherReadRequestDto requestDto = VoucherReadRequestDto.toDto(vo);
        List<VoucherReadResponseDto> lists = voucherService.findVouchers(requestDto);

        List<VoucherReadResponseVo> responseVo = null;

        return new CommonResponseEntity<>(
                HttpStatus.ACCEPTED,
                true,
                "상품권 조회 성공",
                lists.stream().map(VoucherReadResponseDto::toVo).toList());
    }

    // 상품권 삭제 (관리자, 사용자 중 정해야 함)
    @DeleteMapping("/delete/{id}")
    public CommonResponseEntity<Void> deleteVoucher(@PathVariable Long id) {

        voucherService.deleteVoucher(id);

        return new CommonResponseEntity<>(
                HttpStatus.ACCEPTED,
                true,
                "상품권 삭제 성공",
                null
        );
    }

}