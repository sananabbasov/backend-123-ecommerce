package az.edu.itbrains.ecommerce.services;

import az.edu.itbrains.ecommerce.dtos.coupon.CouponDto;

public interface CouponService {
    CouponDto getCoupon(String coupon);
}
