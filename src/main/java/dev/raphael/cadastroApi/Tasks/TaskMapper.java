package dev.raphael.cadastroApi.Tasks;

import dev.raphael.cadastroApi.User.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
    public TasksModel map(TaskDTO taskDTO){
        TasksModel tasksModel = new TasksModel();
        tasksModel.setId(taskDTO.getId());
        tasksModel.setName(taskDTO.getName());
        tasksModel.setDifficulty(taskDTO.getDifficulty());
        tasksModel.setUser(taskDTO.getUser());
        return tasksModel;
    }

    public TaskDTO map(TasksModel tasksModel){
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(tasksModel.getId());
        taskDTO.setName(tasksModel.getName());
        taskDTO.setDifficulty(tasksModel.getDifficulty());
        taskDTO.setUser(tasksModel.getUser());
        return taskDTO;
    }
}
