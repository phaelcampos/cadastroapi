package dev.raphael.cadastroApi.Tasks;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<TaskDTO> findAll(){
        List<TasksModel> tasks = taskRepository.findAll();
        return  tasks.stream()
                .map(taskMapper::map)
                .collect(Collectors.toList());
    }

    public TaskDTO findById(Long id){
        Optional<TasksModel> tasks= taskRepository.findById(id);
        return tasks.map(taskMapper::map).orElse(null);
    }

    public TaskDTO updateTask(TaskDTO taskDTO, Long id){
        Optional<TasksModel> existingTask = taskRepository.findById(id);
        if (existingTask.isPresent()){
            TasksModel updatedTask = taskMapper.map(taskDTO);
            updatedTask.setId(id);
            taskRepository.save(updatedTask);
            return taskMapper.map(updatedTask);
        }
        return null;
    }

    public void deleteById(Long id){
        taskRepository.deleteById(id);
    }
}
