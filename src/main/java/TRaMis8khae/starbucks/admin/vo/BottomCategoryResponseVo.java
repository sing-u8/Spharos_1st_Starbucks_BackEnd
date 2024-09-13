package TRaMis8khae.starbucks.admin.vo;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Builder
public class BottomCategoryResponseVo {

	private String name;

	private String code;
}
