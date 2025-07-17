package dev.raphael.cadastroApi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class CadastroController {

    @GetMapping("/helloWorld")
    public String getMapping(){
        return "hello world";
    }

}
