package net.atos.acelerajava.todo.controller;

import net.atos.acelerajava.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // GetMapping

    // GetMapping com ID

    // PostMapping

    // PutMapping

    // DeleteMapping
}
