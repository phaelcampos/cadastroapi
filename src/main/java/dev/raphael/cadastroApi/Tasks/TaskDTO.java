package dev.raphael.cadastroApi.Tasks;

import dev.raphael.cadastroApi.User.UserModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {
    private Long Id;

    private String name;

    private String difficulty;

    private List<UserModel> user;
}
