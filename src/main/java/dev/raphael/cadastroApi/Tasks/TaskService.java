package dev.raphael.cadastroApi.Tasks;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    public TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public TasksModel save(TasksModel tasksModel){
       return taskRepository.save(tasksModel);
    }

    public List<TasksModel> findAll(){
        return taskRepository.findAll();
    }

    public TasksModel findById(Long id){
        Optional<TasksModel> tasks= taskRepository.findById(id);
        return tasks.orElse(null);
    }
    public void deleteById(Long id){
        taskRepository.deleteById(id);
    }
}
