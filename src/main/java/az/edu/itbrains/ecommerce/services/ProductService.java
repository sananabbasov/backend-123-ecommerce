package az.edu.itbrains.ecommerce.services;

import az.edu.itbrains.ecommerce.dtos.product.ProductDealDto;
import az.edu.itbrains.ecommerce.dtos.product.ProductDetailDto;
import az.edu.itbrains.ecommerce.dtos.product.ProductHomeDto;
import az.edu.itbrains.ecommerce.dtos.product.ProductRelatedDto;
import az.edu.itbrains.ecommerce.models.Product;

import java.util.List;

public interface ProductService {

    List<ProductHomeDto> getHomeProducts();
    ProductDetailDto getProductDetail(Long id);
    List<ProductRelatedDto> getRelatedProducts(Long id);
    ProductDealDto getProductDeal();
}
