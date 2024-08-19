package az.edu.itbrains.ecommerce.models;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "coupons")
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Float discount;
}
