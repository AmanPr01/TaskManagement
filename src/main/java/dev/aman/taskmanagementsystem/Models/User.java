package dev.aman.taskmanagementsystem.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity(name = "users")
public class User extends BaseModel {

    private String userName;
    private String password;

    private String role;

    @ManyToMany(mappedBy = "users", fetch = FetchType.LAZY)
    private List<Task> tasks;

}
