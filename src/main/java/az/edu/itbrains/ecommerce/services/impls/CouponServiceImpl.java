package az.edu.itbrains.ecommerce.services.impls;

import az.edu.itbrains.ecommerce.dtos.coupon.CouponDto;
import az.edu.itbrains.ecommerce.models.Coupon;
import az.edu.itbrains.ecommerce.repositories.CouponRepository;
import az.edu.itbrains.ecommerce.services.CouponService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CouponServiceImpl implements CouponService {

    private final CouponRepository couponRepository;
    private final ModelMapper modelMapper;

    public CouponServiceImpl(CouponRepository couponRepository, ModelMapper modelMapper) {
        this.couponRepository = couponRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CouponDto getCoupon(String coupon) {
      try {
          Coupon findCoupon = couponRepository.findByName(coupon);
          CouponDto couponDto = modelMapper.map(findCoupon,CouponDto.class);
          return couponDto;
      }catch (Exception e){
          return  null;
      }
    }
}
