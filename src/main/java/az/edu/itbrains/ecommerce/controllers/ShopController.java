package az.edu.itbrains.ecommerce.controllers;


import az.edu.itbrains.ecommerce.dtos.basket.BasketAddDto;
import az.edu.itbrains.ecommerce.dtos.coupon.CouponDto;
import az.edu.itbrains.ecommerce.dtos.order.OrderPlaceDto;
import az.edu.itbrains.ecommerce.dtos.product.ProductShopDto;
import az.edu.itbrains.ecommerce.dtos.user.UserBasketDto;
import az.edu.itbrains.ecommerce.dtos.user.UserInfoDto;
import az.edu.itbrains.ecommerce.payloads.PaginationPayload;
import az.edu.itbrains.ecommerce.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class ShopController {

    private final BasketService basketService;
    private final UserService userService;
    private final OrderService orderService;
    private final CouponService couponService;
    private final ProductService productService;

    public ShopController(BasketService basketService, UserService userService, OrderService orderService, CouponService couponService, ProductService productService) {
        this.basketService = basketService;
        this.userService = userService;
        this.orderService = orderService;
        this.couponService = couponService;
        this.productService = productService;
    }


    @GetMapping("/cart")
    public String cart(Model model,Principal principal, String coupon){

        UserBasketDto basket = basketService.getBasket(principal.getName(),coupon);
        CouponDto couponDto = couponService.getCoupon(coupon) ;
        String couponName = couponDto!= null ?  couponService.getCoupon(coupon).getName() : "";
        boolean checkInput = coupon == null ? true : false;


        model.addAttribute("cart", basket);
        model.addAttribute("check", checkInput);
        model.addAttribute("coupon", couponName);
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

    @GetMapping("/basket/remove/{id}")
    public String remove(Principal principal,@PathVariable Long id){
        basketService.removeBasketItem(principal.getName(), id);
        return "redirect:/cart";
    }


    @GetMapping("/shop")
    public String shop(Model model, Integer currentPage){
        PaginationPayload<ProductShopDto> result = productService.getShopProducts(currentPage);
        model.addAttribute("products",result);
        return "shop/index";
    }

}
