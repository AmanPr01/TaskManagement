package dev.aman.taskmanagementsystem.Repositories;

import dev.aman.taskmanagementsystem.Models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Override
    Task getById(Long id);

    @Override
    List<Task> findAll();

    @Override
    boolean existsById(Long id);

    @Override
    void deleteById(Long id);

    Task findByName(String name);

    Task findByDescription(String description);

    @Query(value = "SELECT * FROM Task WHERE status = :status AND priority = :priority", nativeQuery = true)
    List<Task> findByStatusPriorityAndDueDate(@Param("status") String status, @Param("priority") String priority);
}
