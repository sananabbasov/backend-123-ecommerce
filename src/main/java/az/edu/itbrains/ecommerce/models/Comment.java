package az.edu.itbrains.ecommerce.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private Date publish;

    @ManyToOne
    private UserEntity user;

    @ManyToOne
    private Article article;
}
