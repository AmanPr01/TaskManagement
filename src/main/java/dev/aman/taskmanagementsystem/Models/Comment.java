package dev.aman.taskmanagementsystem.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Comment extends BaseModel {
    private String text;

    @ManyToOne
    private  Task task;

    @ManyToOne
    private User user;
}
