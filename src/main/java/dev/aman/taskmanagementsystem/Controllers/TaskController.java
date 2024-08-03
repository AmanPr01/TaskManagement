package dev.aman.taskmanagementsystem.Controllers;

import dev.aman.taskmanagementsystem.DTOs.TaskDTO;
import dev.aman.taskmanagementsystem.Exceptions.TaskNotFoundException;
import dev.aman.taskmanagementsystem.Models.Task;
import dev.aman.taskmanagementsystem.Services.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/task")
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody TaskDTO taskDTO) {
        return taskService.createTask(taskDTO);
    }

    @GetMapping("/findbyid/{id}")
    public Task getTaskById(@PathVariable Long id) throws TaskNotFoundException {
        Optional<Task> optionalTask = taskService.getTaskById(id);

        if (optionalTask.isEmpty()) {
            throw new TaskNotFoundException("Task not found");
        }

        return optionalTask.get();
    }

    @GetMapping("/findall")
    public List<Task> getAllTasks() {
        return taskService.getAllTask();
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, TaskDTO taskDTO) throws TaskNotFoundException {
        return taskService.updateTask(id, taskDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) throws TaskNotFoundException {
        taskService.deleteTask(id);
    }

    @GetMapping("/findbyname/{name}")
    public Task findByName(@PathVariable String name) {
        return taskService.findByName(name);
    }

    @GetMapping("/findbydescription/{description}")
    public Task findByDescription(@PathVariable String description) {
        return taskService.findByDescription(description);
    }

    @GetMapping("/filterbyid")
    public List<Task> findByStatusPriorityAndDueDate(@RequestParam("status") String status, @RequestParam("priority") String priority) {
        return taskService.findByStatusPriorityAndDueDate(status, priority);
    }

}
