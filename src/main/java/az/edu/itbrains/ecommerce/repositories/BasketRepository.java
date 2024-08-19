package az.edu.itbrains.ecommerce.repositories;

import az.edu.itbrains.ecommerce.models.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface BasketRepository extends JpaRepository<Basket, Long> {
    List<Basket> findByUserId(Long userId);
}
