package TRaMis8khae.starbucks.admin.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MiddleCategoryRequestVo {

    private String name;

    private Integer sequence;

    private String TopCategoryCode;

//    private String description;

}
