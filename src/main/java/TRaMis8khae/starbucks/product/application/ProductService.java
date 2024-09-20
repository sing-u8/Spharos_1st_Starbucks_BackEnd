package TRaMis8khae.starbucks.product.application;

import TRaMis8khae.starbucks.product.dto.*;
import TRaMis8khae.starbucks.product.entity.Product;

import java.util.List;

public interface ProductService {

    void addProduct(ProductRequestDto requestDto);

//    void updateProduct(ProductRequestDto requestDto);

    void deleteProduct(String productUUID);

    ProductResponseDto findProduct(String productUUID);

    List<ProductResponseDto> findProducts();

    void addProductOption(ProductOptionRequestDto requestDto);

//    void updateProductOption(ProductOptionRequestDto requestDto);

    void deleteProductOption(String productUUID);

    ProductOptionResponseDto findProductOption(String productUUID);


    VolumeResponseDto findVolume(String productUUID);

    List<ProductResponseDto> findByPrice(Double MinPrice, Double MaxPrice);

//    void addMedia(MediaAddRequestDto requestDto);
//
//    void deleteMedia(String productUUID);
//
//    MediaResponseDto findDetailMedia(String productUUID);
//
//    MediaResponseDto findMedia(String productUUID);

    List<Product> findProductsByProductUUID(List<String> productUUID);

}