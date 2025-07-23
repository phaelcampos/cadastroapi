package dev.raphael.cadastroApi.User;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("User")
public class UserController {

    @GetMapping("/helloWorld")
    public String getMapping(){
        return "hello world";
    }

    @PostMapping("/add")
    public String addUser(){
        return "add user";
    }

    @GetMapping("/all")
    public String getUser(){
        return "Get User";
    }

    @GetMapping("/id")
    public String getUserById(){
        return "Get user by id";
    }

    @PutMapping("/editID")
    public String editUser(){
        return "Edit user";
    }

    @DeleteMapping("/DeleteId")
    public String deleteUser(){
        return "Delete user";
    }
}
