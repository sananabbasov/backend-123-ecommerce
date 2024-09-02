package az.edu.itbrains.ecommerce.dtos.user;


import az.edu.itbrains.ecommerce.dtos.basket.BasketDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBasketDto {

    private double subtotal;
    private double shipping;
    private double total;
    private List<BasketDto> baskets;
}
