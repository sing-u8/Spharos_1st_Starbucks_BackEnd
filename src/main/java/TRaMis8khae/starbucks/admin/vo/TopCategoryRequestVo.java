package TRaMis8khae.starbucks.admin.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TopCategoryRequestVo {

    private String name;

    private Integer sequence;

}