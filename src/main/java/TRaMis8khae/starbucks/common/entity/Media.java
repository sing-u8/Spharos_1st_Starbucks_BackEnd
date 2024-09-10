package TRaMis8khae.starbucks.common.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@Getter
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

}
