package TRaMis8khae.starbucks.voucher.application;

import TRaMis8khae.starbucks.voucher.dto.in.VoucherAddRequestDto;
import TRaMis8khae.starbucks.voucher.dto.in.VoucherRegistRequestDto;
import TRaMis8khae.starbucks.voucher.dto.out.VoucherReadResponseDto;
import TRaMis8khae.starbucks.voucher.entity.MemberVoucherList;
import TRaMis8khae.starbucks.voucher.entity.Voucher;
import TRaMis8khae.starbucks.voucher.infrastructure.MemberVoucherListRepository;
import TRaMis8khae.starbucks.voucher.infrastructure.VoucherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static TRaMis8khae.starbucks.common.utils.CodeGenerator.generateCode;

@Slf4j
@Service
@RequiredArgsConstructor
public class VoucherServiceImpl implements VoucherService {

    private final VoucherRepository voucherRepository;
    private final MemberVoucherListRepository memberVoucherListRepository;

    // 상품권 추가 (관리자),
    @Override
    public void addVoucher(List<VoucherAddRequestDto> requestDtos) {

        for (VoucherAddRequestDto requestDto : requestDtos) {

            String voucherCode = generateCode(12);

            voucherRepository.save(requestDto.toEntity(voucherCode));
        }
    }

    @Override
    public void registVoucher(VoucherRegistRequestDto requestDto) {

        Voucher voucher = voucherRepository.findByVoucherCode(requestDto.getVoucherCode()).orElseThrow();

        // todo 상품권 사용 했다는 로직

        MemberVoucherList memberVoucherList = requestDto.toEntity(voucher, LocalDateTime.now());

        memberVoucherListRepository.save(memberVoucherList);

    }

    @Override
    public void deleteVoucher(Long id) {
        voucherRepository.deleteById(id);
    }

    @Override
    public Slice<VoucherReadResponseDto> findVouchers(Pageable pageable, String memberUUID) {
        return memberVoucherListRepository.findVouchers(pageable, memberUUID);
    }
}