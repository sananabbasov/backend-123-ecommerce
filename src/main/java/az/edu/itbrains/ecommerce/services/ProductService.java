package az.edu.itbrains.ecommerce.services;

import az.edu.itbrains.ecommerce.dtos.product.*;
import az.edu.itbrains.ecommerce.models.Product;
import az.edu.itbrains.ecommerce.payloads.PaginationPayload;

import java.util.List;

public interface ProductService {

    List<ProductHomeDto> getHomeProducts();
    ProductDetailDto getProductDetail(Long id);
    List<ProductRelatedDto> getRelatedProducts(Long id);
    ProductDealDto getProductDeal();
    PaginationPayload<ProductShopDto> getShopProducts(Integer currentPage);
}
