package dev.raphael.cadastroApi.User;

import dev.raphael.cadastroApi.Tasks.TasksModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_user")
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    String name;
    @Column(unique = true)
    String email;
    int age;
    private String imgUrl;
    //ManyToOne= um User só pode ter uma missão
    @ManyToOne()
    @JoinColumn(name = "task_id") //FK
    private TasksModel tasks;
    String rank;
}
