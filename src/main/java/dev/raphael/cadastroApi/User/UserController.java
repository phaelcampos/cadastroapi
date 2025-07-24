package dev.raphael.cadastroApi.User;

import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> addUser(@RequestBody UserDTO user){
        UserDTO newUser = userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("User successfully created: " + newUser.getName() + " (ID): " + newUser.getId());

    }

    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> getUser(){
        List<UserDTO> userList = userService.listUsers();
        return ResponseEntity.status(HttpStatus.OK)
                .body(userList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id){
        if(userService.findById(id) != null) {
            return ResponseEntity.ok(userService.findById(id));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> editUser(@PathVariable Long id, @RequestBody UserDTO user){
        if(userService.findById(id) != null) {
            return ResponseEntity.ok(userService.updateUser(user, id));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        if(userService.findById(id) != null) {
            userService.deleteById(id);
            return ResponseEntity.ok("User successfully deleted: " + id);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("User not found")
                ;
    }
}
