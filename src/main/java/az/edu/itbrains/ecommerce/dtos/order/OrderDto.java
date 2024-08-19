package az.edu.itbrains.ecommerce.dtos.order;

import az.edu.itbrains.ecommerce.models.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long id;
    private String phoneNumber;
    private String address;
    private String message;
    private List<OrderItemDto> orderItems = new ArrayList<>();
}
