package az.edu.itbrains.ecommerce.services;

import az.edu.itbrains.ecommerce.dtos.order.OrderDashboardDto;
import az.edu.itbrains.ecommerce.dtos.order.OrderDetailDto;
import az.edu.itbrains.ecommerce.dtos.order.OrderDto;
import az.edu.itbrains.ecommerce.dtos.order.OrderPlaceDto;

import java.util.List;

public interface OrderService {

    boolean placeOrder(OrderPlaceDto orderDto, String userEmail);
    List<OrderDashboardDto> getDashboardOrder();
    List<OrderDetailDto> getOrderById(Long id);
}
