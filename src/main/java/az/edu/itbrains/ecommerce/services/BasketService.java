package az.edu.itbrains.ecommerce.services;

import az.edu.itbrains.ecommerce.dtos.basket.BasketAddDto;
import az.edu.itbrains.ecommerce.dtos.basket.BasketDto;
import az.edu.itbrains.ecommerce.dtos.user.UserBasketDto;

import java.util.List;

public interface BasketService {

    void addToCart(BasketAddDto basketAddDto, String userEmail);

    UserBasketDto getBasket(String email, String coupon );

    void removeBasketItem(String userEmail, Long id);
}
