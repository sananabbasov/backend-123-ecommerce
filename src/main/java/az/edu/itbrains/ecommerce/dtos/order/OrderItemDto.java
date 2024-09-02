package az.edu.itbrains.ecommerce.dtos.order;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDto {
    private Long id;
    private Double quantity;
    private Double price;
    private Double productId;
}
