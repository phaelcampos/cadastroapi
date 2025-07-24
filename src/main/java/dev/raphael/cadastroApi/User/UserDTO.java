package dev.raphael.cadastroApi.User;
import dev.raphael.cadastroApi.Tasks.TasksModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    Long Id;

    String name;

    String email;

    int age;

    private String imgUrl;

    private TasksModel tasks;

    private String rank;

}
