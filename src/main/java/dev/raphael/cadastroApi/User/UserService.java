package dev.raphael.cadastroApi.User;

import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserModel> listUsers(){
        return userRepository.findAll();
    }

    public UserModel findById(Long id){
        Optional<UserModel> user = userRepository.findById(id);
        return user.orElse(null);
    }

    public UserDTO addUser(UserDTO userDTO){
        UserModel userModel = userMapper.map(userDTO);
        userModel = userRepository.save(userModel);
        return userMapper.map(userModel);
    }

    public void deleteById(Long id){
        userRepository.deleteById(id);
    }
    public UserModel updateUser(UserModel updatedUser, Long id){;
        if(userRepository.existsById(id)){
            //coloca o id para ser atualizado, e salva nesse id o as atts
            updatedUser.setId(id);
            return userRepository.save(updatedUser);
        }
        return null;
    }
}
