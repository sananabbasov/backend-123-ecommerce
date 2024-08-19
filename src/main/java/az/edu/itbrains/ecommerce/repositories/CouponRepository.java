package az.edu.itbrains.ecommerce.repositories;

import az.edu.itbrains.ecommerce.models.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
    Coupon findByName(String name);
}
