package dev.raphael.cadastroApi.User;

import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserDTO> listUsers(){
        List<UserModel> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::map)
                .collect(Collectors.toList());
    }

    public UserDTO findById(Long id){
        Optional<UserModel> user = userRepository.findById(id);
        return user.map(userMapper::map).orElse(null);
    }

    public UserDTO addUser(UserDTO userDTO){
        UserModel userModel = userMapper.map(userDTO);
        userModel = userRepository.save(userModel);
        return userMapper.map(userModel);
    }

    public void deleteById(Long id){
        userRepository.deleteById(id);
    }

    public UserDTO updateUser(UserDTO userDTO, Long id){
        Optional<UserModel> existingUser = userRepository.findById(id);
        if(existingUser.isPresent()){
            UserModel updatedUser = userMapper.map(userDTO);
            updatedUser.setId(id);
            UserModel savedUser = userRepository.save(updatedUser);
            return userMapper.map(savedUser);
        }
        return null;
    }
}
