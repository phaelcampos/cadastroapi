package dev.raphael.cadastroApi.Tasks;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    public TaskRepository taskRepository;
    public TaskMapper taskMapper;

    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    public TaskDTO save(TaskDTO taskDTO){
        TasksModel tasksModel = taskMapper.map(taskDTO);
        tasksModel = taskRepository.save(tasksModel);
        return taskMapper.map(tasksModel);
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
