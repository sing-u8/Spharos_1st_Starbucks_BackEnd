package TRaMis8khae.starbucks.vendor.infrastructure;


import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductOptionRepositoryCustom {

	List<String> getProductUUIDByVolume(String volumeName);

}
