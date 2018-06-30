package ru.reactivetodo.backend.controller.exceptions;

public class TaskAlreadyCheckedException extends ConflictException {
    public TaskAlreadyCheckedException() {
        super("Task already checked");
    }
}
