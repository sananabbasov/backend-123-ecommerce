package az.edu.itbrains.ecommerce.services.impls;

import az.edu.itbrains.ecommerce.dtos.user.UserInfoDto;
import az.edu.itbrains.ecommerce.dtos.user.UserRegisterDto;
import az.edu.itbrains.ecommerce.models.UserEntity;
import az.edu.itbrains.ecommerce.repositories.UserRepository;
import az.edu.itbrains.ecommerce.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public boolean register(UserRegisterDto userRegisterDto) {
        try {
            UserEntity findUser = userRepository.findByEmail(userRegisterDto.getEmail());
            if (findUser != null){
                return false;
            }
            UserEntity user = modelMapper.map(userRegisterDto, UserEntity.class);
            String password = bCryptPasswordEncoder.encode(userRegisterDto.getPassword());
            user.setPassword(password);
            UUID uuid = UUID.randomUUID();
            user.setEmailToken(uuid.toString());
            user.setEmailConfirmed(false);
            userRepository.save(user);
            return true;

        }catch (Exception e){
            return false;
        }
    }

    @Override
    public UserInfoDto getUserInfo(String userEmail) {
        UserEntity user = userRepository.findByEmail(userEmail);
        UserInfoDto result = modelMapper.map(user, UserInfoDto.class);
        return result;
    }
}
