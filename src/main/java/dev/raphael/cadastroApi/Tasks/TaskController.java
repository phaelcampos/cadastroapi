package dev.raphael.cadastroApi.Tasks;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<TaskDTO>> list(){
        List<TaskDTO> tasks = taskService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> list(@PathVariable Long id){
        if(taskService.findById(id) != null){
            return ResponseEntity.status(HttpStatus.OK).body(taskService.findById(id));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    @PostMapping
    public ResponseEntity<String> save(@RequestBody TaskDTO taskDTO){
        TaskDTO newUser = taskService.save(taskDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("User successfully created: " + newUser.getName() + " (ID): " + newUser.getId());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> editUser(@PathVariable Long id, @RequestBody TaskDTO user){
        if(taskService.findById(id) != null) {
            return ResponseEntity.ok(taskService.updateTask(user, id));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        if(taskService.findById(id) != null) {
            taskService.deleteById(id);
            return ResponseEntity.ok().body("User successfully deleted: " + id);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
