package az.edu.itbrains.ecommerce.services;

import az.edu.itbrains.ecommerce.dtos.order.OrderDto;
import az.edu.itbrains.ecommerce.dtos.order.OrderPlaceDto;

public interface OrderService {

    boolean placeOrder(OrderPlaceDto orderDto, String userEmail);

}
