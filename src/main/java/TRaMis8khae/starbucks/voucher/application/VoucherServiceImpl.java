package TRaMis8khae.starbucks.voucher.application;

import TRaMis8khae.starbucks.voucher.dto.*;
import TRaMis8khae.starbucks.voucher.entity.MemberVoucherList;
import TRaMis8khae.starbucks.voucher.entity.Voucher;
import TRaMis8khae.starbucks.voucher.infrastructure.MemberVoucherListRepository;
import TRaMis8khae.starbucks.voucher.infrastructure.VoucherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VoucherServiceImpl implements VoucherService {

    private final VoucherRepository voucherRepository;
    private final MemberVoucherListRepository memberVoucherListRepository;

    // 상품권 추가 (관리자)
    @Override
    public List<VoucherAddResponseDto> addVoucher(List<VoucherAddRequestDto> requestDtos) {

        List<VoucherAddResponseDto> responseDtoList = new ArrayList<>();

        for (VoucherAddRequestDto requestDto : requestDtos) {

            String voucherCode = UUID.randomUUID().toString().substring(0, 12);
            Voucher voucher = VoucherAddRequestDto.toEntity(requestDto, voucherCode);

            Voucher savedVoucher = voucherRepository.save(voucher);

            VoucherAddResponseDto responseDto = VoucherAddResponseDto.toDto(savedVoucher);

            responseDtoList.add(responseDto);
        }

        return responseDtoList;
    }

    @Override
    public Void registVoucher(VoucherRegistRequestDto requestDto) {

        Voucher voucher = voucherRepository.findByVoucherCode(requestDto.getVoucherCode()).orElseThrow();

        // todo 상품권 사용 했다는 로직

        MemberVoucherList memberVoucherList = VoucherRegistRequestDto.toEntity(requestDto, voucher, LocalDateTime.now());

        memberVoucherListRepository.save(memberVoucherList);

        return null;
    }

    @Override
    public void deleteVoucher(Long id) {
        voucherRepository.deleteById(id);
    }

    @Override
    public List<VoucherReadResponseDto> findVouchers(VoucherReadRequestDto dto) {

        List<MemberVoucherList> memberVoucherList = memberVoucherListRepository
                .findAllByMemberUUID(dto.getMemberUUID());


        for (MemberVoucherList list  : memberVoucherList ) {
            VoucherReadResponseDto.toDto(list);
        }

//        memberVoucherList.stream().map(list -> {
//            return VoucherReadResponseDto.toDto(list, list.getVoucher());
//        });




        return memberVoucherList.stream().map(VoucherReadResponseDto::toDto).toList();
    }

}