package TRaMis8khae.starbucks.admin.dto.out;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MenuCategoryResponseDto {

	private Long productCategoryId;

	private String imageUrl;

}
