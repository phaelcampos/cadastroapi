package dev.raphael.cadastroApi.Tasks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.raphael.cadastroApi.User.UserModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tb_tasks")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TasksModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private String difficulty;
    //OneToMany= uma task para vários users
    @OneToMany(mappedBy = "tasks")
    @JsonIgnore
    private List<UserModel> user;
}
