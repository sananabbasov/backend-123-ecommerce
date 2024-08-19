package az.edu.itbrains.ecommerce.services.impls;

import az.edu.itbrains.ecommerce.dtos.basket.BasketAddDto;
import az.edu.itbrains.ecommerce.dtos.basket.BasketDto;
import az.edu.itbrains.ecommerce.models.Basket;
import az.edu.itbrains.ecommerce.models.Product;
import az.edu.itbrains.ecommerce.models.UserEntity;
import az.edu.itbrains.ecommerce.repositories.BasketRepository;
import az.edu.itbrains.ecommerce.repositories.ProductRepository;
import az.edu.itbrains.ecommerce.repositories.UserRepository;
import az.edu.itbrains.ecommerce.services.BasketService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BasketServiceImpl implements BasketService {

    private final BasketRepository basketRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public BasketServiceImpl(BasketRepository basketRepository, UserRepository userRepository, ProductRepository productRepository, ModelMapper modelMapper) {
        this.basketRepository = basketRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public void addToCart(BasketAddDto basketAddDto, String userEmail) {
        try{
            UserEntity findUser = userRepository.findByEmail(userEmail);
            List<Basket> findBasket = basketRepository.findByUserId(findUser.getId());

            if (findBasket.isEmpty()){
                Product findProduct = productRepository.findById(basketAddDto.getProductId()).orElseThrow();
                Basket basket = new Basket();
                basket.setUser(findUser);
                basket.setProduct(findProduct);
                basket.setQuantity(basketAddDto.getQuantity());
                basketRepository.save(basket);
            }else{
                Optional<Basket> find = findBasket.stream().filter(x->x.getProduct().getId() == basketAddDto.getProductId()).findFirst();

                if (find.isEmpty()){
                    Product findProduct = productRepository.findById(basketAddDto.getProductId()).orElseThrow();
                    Basket basket = new Basket();
                    basket.setUser(findUser);
                    basket.setProduct(findProduct);
                    basket.setQuantity(basketAddDto.getQuantity());
                    basketRepository.save(basket);
                }else{
                    find.get().setQuantity(find.get().getQuantity() + basketAddDto.getQuantity());
                    basketRepository.save(find.get());
                }

            }
        }catch (Exception e){
            String error = e.getMessage();
            System.out.println(error);
        }
    }

    @Override
    public List<BasketDto> getBasket(String email) {
        UserEntity findUser = userRepository.findByEmail(email);
        List<Basket> findBasket = basketRepository.findByUserId(findUser.getId());
        List<BasketDto> basket = findBasket.stream().map(x-> modelMapper.map(x, BasketDto.class)).collect(Collectors.toList());
        return basket;
    }
}
