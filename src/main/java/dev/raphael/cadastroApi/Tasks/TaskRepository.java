package dev.raphael.cadastroApi.Tasks;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository  extends JpaRepository<TasksModel, Long> {
}
