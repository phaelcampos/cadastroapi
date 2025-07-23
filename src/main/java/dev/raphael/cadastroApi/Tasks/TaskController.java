package dev.raphael.cadastroApi.Tasks;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @GetMapping
    public String list(){
        return "Lista de tasks";
    }

    @PostMapping
    public String save(){
        return "Lista de tasks";
    }

    @PutMapping
    public String update(){
        return "Lista de tasks";
    }

    @DeleteMapping
    public String delete(){
        return "Lista de tasks";
    }
}
