package TRaMis8khae.starbucks.admin.presentation;

import TRaMis8khae.starbucks.admin.application.CategoryService;
import TRaMis8khae.starbucks.admin.vo.MainCategoryResponseVo;
import TRaMis8khae.starbucks.admin.vo.SubCategoryResponseVo;
import TRaMis8khae.starbucks.common.entity.CommonResponseEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/product_category")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/main")
    public CommonResponseEntity<Void> createMainCategory() {
        return null;
    }

    @PostMapping("/main/sub")
    public CommonResponseEntity<Void> createSubCategory() {
        return null;
    }

    @DeleteMapping
    public CommonResponseEntity<Void> deleteMainCategory() {
        return null;
    }

    @DeleteMapping
    public CommonResponseEntity<Void> deleteSubCategory() {
        return null;
    }

    @GetMapping("/{mainCategory}")
    public CommonResponseEntity<MainCategoryResponseVo> getMainCategory() {
        return null;
    }

    @GetMapping("/{subCategory}")
    public CommonResponseEntity<SubCategoryResponseVo> getSubCategory() {
        return null;
    }
}
