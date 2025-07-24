package dev.raphael.cadastroApi.User;

import org.springframework.stereotype.Component;

//mapper faz a "ligação" do DTO com o Model
//Ele precisa do component
@Component
public class UserMapper {
    public UserModel map(UserDTO userDTO){
        UserModel userModel = new UserModel();
        userModel.setId(userDTO.getId());
        userModel.setEmail(userDTO.getEmail());
        userModel.setName(userDTO.getName());
        userModel.setRank(userDTO.getRank());
        userModel.setImgUrl(userDTO.getImgUrl());
        userModel.setAge(userDTO.getAge());
        userModel.setTasks(userDTO.getTasks());
        return userModel;
    }

    public UserDTO map(UserModel userModel){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userModel.getId());
        userDTO.setEmail(userModel.getEmail());
        userDTO.setName(userModel.getName());
        userDTO.setRank(userModel.getRank());
        userDTO.setImgUrl(userModel.getImgUrl());
        userDTO.setAge(userModel.getAge());
        userDTO.setTasks(userModel.getTasks());
        return userDTO;
    }
}
