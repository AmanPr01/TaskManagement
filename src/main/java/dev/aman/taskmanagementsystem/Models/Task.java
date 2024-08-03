package dev.aman.taskmanagementsystem.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Task extends BaseModel {
    private String name;
    private String description;

    @Enumerated(EnumType.ORDINAL)
    private TaskStatus status;

    private String priority;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<User> users;
}
