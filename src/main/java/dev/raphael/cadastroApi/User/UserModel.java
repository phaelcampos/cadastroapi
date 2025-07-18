package dev.raphael.cadastroApi.User;

import dev.raphael.cadastroApi.Tasks.TasksModel;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_user")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    String name;
    String email;
    int age;

    //ManyToOne= um User só pode ter uma missão
    @ManyToOne()
    @JoinColumn(name = "task_id") //FK
    private TasksModel tasks;

    public UserModel() {

    }

    public UserModel(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
