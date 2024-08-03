package dev.aman.taskmanagementsystem.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserDTO {
    private String username;
    private String password;
    private String role;
}
