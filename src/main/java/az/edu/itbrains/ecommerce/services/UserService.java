package az.edu.itbrains.ecommerce.services;

import az.edu.itbrains.ecommerce.dtos.user.UserInfoDto;
import az.edu.itbrains.ecommerce.dtos.user.UserRegisterDto;

public interface UserService {

    boolean register(UserRegisterDto userRegisterDto);
    UserInfoDto getUserInfo(String userEmail);
}
