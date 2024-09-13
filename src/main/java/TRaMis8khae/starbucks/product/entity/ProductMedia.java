package TRaMis8khae.starbucks.product.entity;


import TRaMis8khae.starbucks.common.entity.Media;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@NoArgsConstructor
public class ProductMedia extends Media {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String productUUID;

	@Builder
	public ProductMedia(
		String path, Boolean thumbChecked,
		Boolean mainChecked, Boolean detailChecked,
		Boolean productChecked, String productUUID) {

		super(path, thumbChecked, mainChecked, detailChecked, productChecked);
		this.productUUID = productUUID;
	}


}
