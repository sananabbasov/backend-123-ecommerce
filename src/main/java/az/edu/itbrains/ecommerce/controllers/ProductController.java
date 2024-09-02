package az.edu.itbrains.ecommerce.controllers;

import az.edu.itbrains.ecommerce.dtos.product.ProductDetailDto;
import az.edu.itbrains.ecommerce.dtos.product.ProductRelatedDto;
import az.edu.itbrains.ecommerce.models.Product;
import az.edu.itbrains.ecommerce.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/product/detail/{id}")
    public String detail(@PathVariable Long id, Model model)
    {
        ProductDetailDto product = productService.getProductDetail(id);
        List<ProductRelatedDto> relatedProducts = productService.getRelatedProducts(product.getId());
        model.addAttribute("product",product);
        model.addAttribute("relatedProducts",relatedProducts);
        return "/shop/detail";
    }






}
