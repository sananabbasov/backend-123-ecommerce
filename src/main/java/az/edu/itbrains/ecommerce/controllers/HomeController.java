package az.edu.itbrains.ecommerce.controllers;


import az.edu.itbrains.ecommerce.dtos.product.ProductDealDto;
import az.edu.itbrains.ecommerce.dtos.product.ProductHomeDto;
import az.edu.itbrains.ecommerce.dtos.slider.SliderHomeDto;
import az.edu.itbrains.ecommerce.dtos.testimonial.TestimonialDto;
import az.edu.itbrains.ecommerce.services.ProductService;
import az.edu.itbrains.ecommerce.services.SliderService;
import az.edu.itbrains.ecommerce.services.TestimonialService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final ProductService productService;
    private final SliderService sliderService;
    private final TestimonialService testimonialService;


    public HomeController(ProductService productService, SliderService sliderService, TestimonialService testimonialService) {
        this.productService = productService;
        this.sliderService = sliderService;
        this.testimonialService = testimonialService;
    }


    @GetMapping("/")
    public String home(Model model){
        List<ProductHomeDto> products = productService.getHomeProducts();
        List<SliderHomeDto> sliders = sliderService.getSliders();
        ProductDealDto deal = productService.getProductDeal();
        List<TestimonialDto> testimonials = testimonialService.getTestimonials();
        model.addAttribute("products",products);
        model.addAttribute("sliders",sliders);
        model.addAttribute("deal",deal);
        model.addAttribute("testimonials",testimonials);
        return "index";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }

    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }
}
