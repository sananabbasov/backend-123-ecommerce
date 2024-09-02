package az.edu.itbrains.ecommerce.controllers;

import az.edu.itbrains.ecommerce.dtos.order.OrderDashboardDto;
import az.edu.itbrains.ecommerce.dtos.order.OrderDetailDto;
import az.edu.itbrains.ecommerce.services.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/admin/order")
    public String index(Model model){
        List<OrderDashboardDto> orders = orderService.getDashboardOrder();
        model.addAttribute("orders",orders);
        return "/dashboard/order/index";
    }


    @GetMapping("/admin/order/{id}")
    public String detail(Model model, @PathVariable Long id){
        List<OrderDetailDto> order = orderService.getOrderById(id);
        model.addAttribute("orders",order);
        return "/dashboard/order/detail";
    }
}
