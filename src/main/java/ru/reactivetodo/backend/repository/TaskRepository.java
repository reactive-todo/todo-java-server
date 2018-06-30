package ru.reactivetodo.backend.repository;

import org.springframework.data.repository.CrudRepository;
import ru.reactivetodo.backend.model.Task;

public interface TaskRepository extends CrudRepository<Task, Long> {
}
