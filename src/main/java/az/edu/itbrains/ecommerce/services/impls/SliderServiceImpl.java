package az.edu.itbrains.ecommerce.services.impls;

import az.edu.itbrains.ecommerce.dtos.slider.SliderHomeDto;
import az.edu.itbrains.ecommerce.models.Slider;
import az.edu.itbrains.ecommerce.repositories.SliderRepository;
import az.edu.itbrains.ecommerce.services.SliderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SliderServiceImpl implements SliderService {

    private final SliderRepository sliderRepository;
    private final ModelMapper modelMapper;

    public SliderServiceImpl(SliderRepository sliderRepository, ModelMapper modelMapper) {
        this.sliderRepository = sliderRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<SliderHomeDto> getSliders() {
        List<Slider> sliders = sliderRepository.findAll();
        List<SliderHomeDto> result = sliders.stream().map(slider -> modelMapper.map(slider, SliderHomeDto.class)).collect(Collectors.toList());
        return result;
    }
}
