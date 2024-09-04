package TRaMis8khae.starbucks.admin.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MainCategoryResponseVo {
    private String mainCategoryName;
    private Integer mainCategoryOrder;
}
