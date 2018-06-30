package ru.reactivetodo.backend.controller.exceptions;

public class TaskAlreadyUncheckedException extends ConflictException {
    public TaskAlreadyUncheckedException() {
        super("Task already unchecked");
    }
}
