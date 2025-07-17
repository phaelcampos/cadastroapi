package dev.raphael.cadastroApi.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserController {

    @GetMapping("/helloWorld")
    public String getMapping(){
        return "hello world";
    }

}
