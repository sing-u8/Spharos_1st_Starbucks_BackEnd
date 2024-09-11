package TRaMis8khae.starbucks.vendor.infrastructure;


import TRaMis8khae.starbucks.vendor.entity.ProductCategoryList;
import TRaMis8khae.starbucks.vendor.entity.QProductCategoryList;
import com.querydsl.core.BooleanBuilder;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductCategoryListRepositoryCustom {

	List<ProductCategoryList> findProductsByCategories(String topCode, String middleCode);

}
