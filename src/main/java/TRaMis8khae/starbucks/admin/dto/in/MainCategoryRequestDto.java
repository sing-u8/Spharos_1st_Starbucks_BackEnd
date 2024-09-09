package TRaMis8khae.starbucks.admin.dto.in;

import TRaMis8khae.starbucks.admin.entity.MainCategory;
import TRaMis8khae.starbucks.admin.vo.MainCategoryRequestVo;
import lombok.Getter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MainCategoryRequestDto {

    private String name;
    private Integer sequence;//순서

    public static MainCategoryRequestDto toDto(MainCategoryRequestVo mainCategoryRequestVo) {
        return MainCategoryRequestDto.builder()
                .name(mainCategoryRequestVo.getName())
                .sequence(mainCategoryRequestVo.getSequence())
                .build();
    }

    public MainCategory toEntity(String code) {
        return MainCategory.builder()
                .name(name)
                .sequence(sequence)
                .code(code)
                .build();
    }

}