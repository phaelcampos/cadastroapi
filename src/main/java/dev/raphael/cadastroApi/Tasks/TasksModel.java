package dev.raphael.cadastroApi.Tasks;

import dev.raphael.cadastroApi.User.UserModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_tasks")
public class TasksModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private String difficulty;
    //OneToMany= uma task para vários users
    @OneToMany(mappedBy = "tasks")
    private List<UserModel> user;
}
