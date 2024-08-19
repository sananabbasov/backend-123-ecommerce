package az.edu.itbrains.ecommerce.services;

import az.edu.itbrains.ecommerce.dtos.basket.BasketAddDto;
import az.edu.itbrains.ecommerce.dtos.basket.BasketDto;

import java.util.List;

public interface BasketService {

    void addToCart(BasketAddDto basketAddDto, String userEmail);

    List<BasketDto> getBasket(String email);
}
