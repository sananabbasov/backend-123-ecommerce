package az.edu.itbrains.ecommerce.services.impls;

import az.edu.itbrains.ecommerce.dtos.testimonial.TestimonialDto;
import az.edu.itbrains.ecommerce.models.Testimonial;
import az.edu.itbrains.ecommerce.repositories.TestimonialRepository;
import az.edu.itbrains.ecommerce.services.TestimonialService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestimonialImpl implements TestimonialService {

    private final TestimonialRepository testimonialRepository;
    private final ModelMapper modelMapper;

    public TestimonialImpl(TestimonialRepository testimonialRepository, ModelMapper modelMapper) {
        this.testimonialRepository = testimonialRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<TestimonialDto> getTestimonials() {
        List<Testimonial> findTestimonials = testimonialRepository.findAll();
        List<TestimonialDto> testimonials = findTestimonials.stream().map(x-> modelMapper.map(x,TestimonialDto.class)).collect(Collectors.toList());
        return testimonials;
    }
}
