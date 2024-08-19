package az.edu.itbrains.ecommerce.services;

import az.edu.itbrains.ecommerce.dtos.slider.SliderHomeDto;

import java.util.List;

public interface SliderService {
    List<SliderHomeDto> getSliders();
}
