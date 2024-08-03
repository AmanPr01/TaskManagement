package dev.aman.taskmanagementsystem.DTOs;

import dev.aman.taskmanagementsystem.Models.TaskStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TaskDTO {
    private String title;
    private String description;
    private TaskStatus status;
    private String priority;
    private Long id;
    private List<UserDTO> users;
}
