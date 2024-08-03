package dev.aman.taskmanagementsystem.Services;

import dev.aman.taskmanagementsystem.DTOs.TaskDTO;
import dev.aman.taskmanagementsystem.DTOs.UserDTO;
import dev.aman.taskmanagementsystem.Exceptions.TaskNotFoundException;
import dev.aman.taskmanagementsystem.Models.Task;
import dev.aman.taskmanagementsystem.Models.TaskStatus;
import dev.aman.taskmanagementsystem.Models.User;
import dev.aman.taskmanagementsystem.Repositories.TaskRepository;
import dev.aman.taskmanagementsystem.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final UserRepository userRepository;
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public Task createTask(TaskDTO taskDTO) {
        Task task = new Task();
        task.setDescription(taskDTO.getDescription());
        task.setId(taskDTO.getId());
        task.setPriority(taskDTO.getPriority());
        task.setName(taskDTO.getTitle());
        task.setStatus(taskDTO.getStatus());

        List<User> users = new ArrayList<>();
        for (UserDTO userDTO : taskDTO.getUsers()) {
            User user = new User();
            user.setUserName(userDTO.getUsername());
            user.setPassword(userDTO.getPassword());
            user.setRole(userDTO.getRole());
            users.add(user);
        }

        userRepository.saveAll(users);

        task.setUsers(users);

        return taskRepository.save(task);
    }

    public Optional<Task> getTaskById(Long id) throws TaskNotFoundException {
        Optional<Task> optionalTask = taskRepository.findById(id);

        if (optionalTask.isEmpty()) {
            throw new TaskNotFoundException("Task not found for taskId: " + id);
        }

        return optionalTask;
    }

    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    public Task updateTask(Long id, TaskDTO taskDTO) throws TaskNotFoundException {
        Optional<Task> optionalTask = taskRepository.findById(id);

        if (optionalTask.isEmpty()) {
            throw new TaskNotFoundException("Task not found with taskId: " + id);
        }

        Task task = optionalTask.get();
        task.setName(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setPriority(taskDTO.getPriority());
        task.setStatus(taskDTO.getStatus());
        task.setId(taskDTO.getId());

        List<User> users = new ArrayList<>();
        for (UserDTO userDTO : taskDTO.getUsers()) {
            User user = new User();
            user.setUserName(userDTO.getUsername());
            user.setPassword(userDTO.getPassword());
            user.setRole(userDTO.getRole());
            users.add(user);
        }

        userRepository.saveAll(users);

        task.setUsers(users);

        return taskRepository.save(task);
    }

    public void deleteTask(Long id) throws TaskNotFoundException {
        Optional<Task> optionalTask = taskRepository.findById(id);

        if (optionalTask.isEmpty()) {
            throw new TaskNotFoundException("Task not found with taskId: " + id);
        }

        taskRepository.deleteById(id);
    }

    public Task findByName(String name) {
        return taskRepository.findByName(name);
    }

    public Task findByDescription(String description) {
        return taskRepository.findByDescription(description);
    }

    public List<Task> findByStatusPriorityAndDueDate(String status, String priority) {
        return taskRepository.findByStatusPriorityAndDueDate(status, priority);
    }
}
