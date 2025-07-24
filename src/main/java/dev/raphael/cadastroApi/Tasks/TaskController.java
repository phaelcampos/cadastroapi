package dev.raphael.cadastroApi.Tasks;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    public TaskService taskService;
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping("/")
    public List<TasksModel> list(){
        return taskService.findAll();
    }

    @GetMapping("/{id}")
    public TasksModel list(@PathVariable Long id){
        return taskService.findById(id);
    }
    @PostMapping
    public TasksModel save(@RequestBody TasksModel tasksModel){
        return taskService.save(tasksModel);
    }

    @PutMapping
    public String update(){
        return "Lista de tasks";
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        taskService.deleteById(id);
    }
}
