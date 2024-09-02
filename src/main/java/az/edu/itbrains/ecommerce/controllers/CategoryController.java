package az.edu.itbrains.ecommerce.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryController {


    @GetMapping("/admin/category")
    public String category(){
        return "/dashboard/category";
    }
}
