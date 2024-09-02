package az.edu.itbrains.ecommerce.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    @Column(length = 1000)
    private String description;
    private Double quantity;
    private String photoUrl;
    private Date discountDate;
    private Double discountPrice;
    private Boolean featured;
    @ManyToOne
    private Category category;

}
