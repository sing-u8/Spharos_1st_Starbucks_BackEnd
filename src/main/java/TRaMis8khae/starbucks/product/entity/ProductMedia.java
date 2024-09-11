package TRaMis8khae.starbucks.product.entity;


import TRaMis8khae.starbucks.common.entity.Media;
import jakarta.persistence.*;


@Entity
public class ProductMedia extends Media {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String productUUID;

}
