package az.edu.itbrains.ecommerce.dtos.testimonial;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestimonialDto {
    private Long id;
    private String photoUrl;
    private String fullName;
    private String position;
    private String content;
}
