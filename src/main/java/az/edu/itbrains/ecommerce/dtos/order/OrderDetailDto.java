package az.edu.itbrains.ecommerce.dtos.order;

import az.edu.itbrains.ecommerce.dtos.product.ProductDetailDto;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailDto {
    private Long id;
    private Double quantity;
    private Double price;
    private ProductDetailDto product;
}
