package ru.reactivetodo.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.reactivetodo.backend.controller.exceptions.NotFoundException;
import ru.reactivetodo.backend.controller.exceptions.TaskAlreadyCheckedException;
import ru.reactivetodo.backend.controller.exceptions.TaskAlreadyUncheckedException;
import ru.reactivetodo.backend.model.Task;
import ru.reactivetodo.backend.repository.TaskRepository;

@RestController
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/tasks")
    public Iterable<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @PutMapping("/tasks/{id}/check")
    public void check(@PathVariable Long id) {
        Task task = taskRepository.findById(id).orElseThrow(NotFoundException::new);
        if (task.isChecked()) throw new TaskAlreadyCheckedException();
        task.setChecked(true);
        taskRepository.save(task);
    }

    @PutMapping("/tasks/{id}/uncheck")
    public void uncheck(@PathVariable Long id) {
        Task task = taskRepository.findById(id).orElseThrow(NotFoundException::new);
        if (!task.isChecked()) throw new TaskAlreadyUncheckedException();
        task.setChecked(false);
        taskRepository.save(task);
    }
}
