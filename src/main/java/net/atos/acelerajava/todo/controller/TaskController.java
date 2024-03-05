package net.atos.acelerajava.todo.controller;

import net.atos.acelerajava.todo.model.Task;
import net.atos.acelerajava.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String showTasks(Model model) {
        Task task = TaskService.populate(model);
        model.addAttribute("task", task);
        model.addAttribute("tasks", this.taskService.getAllTasks());
        return "layout";
    }

    @PostMapping("/save")
    public String saveTask(Task task) {
        this.taskService.createTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/edit/{id}")
    public String editTask(RedirectAttributes attributes, @PathVariable("id") Long id) {
        attributes.addFlashAttribute("taskForEdit", this.taskService.findTaskById(id));
        return "redirect:/tasks";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") Long id) {
        this.taskService.deleteTask(id);
        return "redirect:/tasks";
    }
}
