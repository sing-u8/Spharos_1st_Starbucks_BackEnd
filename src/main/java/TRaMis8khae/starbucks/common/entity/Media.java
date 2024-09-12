package TRaMis8khae.starbucks.common.entity;

import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public abstract class Media {

	private String path;

	private Boolean thumbChecked;

	private Boolean mainChecked;

	private Boolean detailChecked;

	private Boolean videoChecked;

	private Boolean imageChecked;

	private Boolean productChecked;

	private Boolean reviewChecked;

	private Boolean eventChecked;

	protected Media(
		String path, Boolean thumbChecked,
		Boolean mainChecked, Boolean detailChecked,
		Boolean productChecked) {
		this.path = path;
		this.thumbChecked = thumbChecked;
		this.mainChecked = mainChecked;
		this.detailChecked = detailChecked;
		this.productChecked = productChecked;
	}


}
