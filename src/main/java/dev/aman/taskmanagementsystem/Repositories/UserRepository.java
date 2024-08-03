package dev.aman.taskmanagementsystem.Repositories;

import dev.aman.taskmanagementsystem.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUserName(String userName);
}
