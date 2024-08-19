package az.edu.itbrains.ecommerce.controllers;


import az.edu.itbrains.ecommerce.dtos.basket.BasketAddDto;
import az.edu.itbrains.ecommerce.dtos.basket.BasketDto;
import az.edu.itbrains.ecommerce.dtos.coupon.CouponDto;
import az.edu.itbrains.ecommerce.dtos.order.OrderPlaceDto;
import az.edu.itbrains.ecommerce.dtos.user.UserInfoDto;
import az.edu.itbrains.ecommerce.services.BasketService;
import az.edu.itbrains.ecommerce.services.CouponService;
import az.edu.itbrains.ecommerce.services.OrderService;
import az.edu.itbrains.ecommerce.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

@Controller
public class ShopController {

    private final BasketService basketService;
    private final UserService userService;
    private final OrderService orderService;
    private final CouponService couponService;

    public ShopController(BasketService basketService, UserService userService, OrderService orderService, CouponService couponService) {
        this.basketService = basketService;
        this.userService = userService;
        this.orderService = orderService;
        this.couponService = couponService;
    }


    @GetMapping("/cart")
    public String cart(Model model,Principal principal, String coupon){

        List<BasketDto> basket = basketService.getBasket(principal.getName());
        Double price = basket.stream().map(x->x.getProduct().getPrice() * x.getQuantity()).mapToDouble(x->x).sum();
        BigDecimal roundPrice;
        CouponDto couponDto = couponService.getCoupon(coupon);
        if (couponDto != null){
            price = price - (price * couponDto.getDiscount() / 100);
        }
        model.addAttribute("subtotal", String.format(price.toString(), 2));
        model.addAttribute("baskets", basket);
        model.addAttribute("coupon", couponDto.getName());
        return "shop/cart";
    }


    @PostMapping("/cart")
    public String basket(BasketAddDto basketAddDto, Principal principal){
        basketService.addToCart(basketAddDto, principal.getName());
        return "redirect:cart";
    }


    @GetMapping("/checkout")
    public String checkout(Model model, Principal principal){
        UserInfoDto user = userService.getUserInfo(principal.getName());
        model.addAttribute("user",user);
        return "shop/checkout";
    }


    @PostMapping("/checkout")
    public String checkout(Principal principal, OrderPlaceDto orderPlaceDto){
        orderService.placeOrder(orderPlaceDto,principal.getName());
        return "redirect:/";
    }



}
