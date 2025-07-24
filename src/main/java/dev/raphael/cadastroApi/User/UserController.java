package dev.raphael.cadastroApi.User;

import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/helloWorld")
    public String getMapping(){
        return "hello world";
    }

    @PostMapping("/")
    public UserDTO addUser(@RequestBody UserDTO user){
        return userService.addUser(user);
    }

    @GetMapping("/")
    public List<UserDTO> getUser(){
        return userService.listUsers();
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id){
        return userService.findById(id);
    }

    @PatchMapping("/{id}")
    public UserDTO editUser(@PathVariable Long id, @RequestBody UserDTO user){
        return userService.updateUser(user, id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteById(id);
    }
}
