package az.edu.itbrains.ecommerce.services.impls;

import az.edu.itbrains.ecommerce.dtos.order.OrderPlaceDto;
import az.edu.itbrains.ecommerce.models.Basket;
import az.edu.itbrains.ecommerce.models.Order;
import az.edu.itbrains.ecommerce.models.OrderItem;
import az.edu.itbrains.ecommerce.models.UserEntity;
import az.edu.itbrains.ecommerce.repositories.BasketRepository;
import az.edu.itbrains.ecommerce.repositories.OrderItemRepository;
import az.edu.itbrains.ecommerce.repositories.OrderRepository;
import az.edu.itbrains.ecommerce.repositories.UserRepository;
import az.edu.itbrains.ecommerce.services.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {


    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final BasketRepository basketRepository;
    private final OrderItemRepository orderItemRepository;

    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper, UserRepository userRepository, BasketRepository basketRepository, OrderItemRepository orderItemRepository) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.basketRepository = basketRepository;
        this.orderItemRepository = orderItemRepository;
    }


    @Override
    public boolean placeOrder(OrderPlaceDto orderDto, String userEmail) {

        UserEntity user = userRepository.findByEmail(userEmail);
        Order order = modelMapper.map(orderDto, Order.class);
        order.setUser(user);
        orderRepository.save(order);
        List<Basket> findBasket = basketRepository.findByUserId(user.getId());
        for (Basket basket: findBasket) {
            OrderItem orderItem = new OrderItem();
            orderItem.setQuantity(basket.getQuantity());
            orderItem.setPrice(basket.getProduct().getPrice());
            orderItem.setProduct(basket.getProduct());
            orderItem.setOrder(order);
            orderItemRepository.save(orderItem);
        }
        basketRepository.deleteAll(findBasket);
        return true;
    }
}
