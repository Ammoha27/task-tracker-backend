package com.example.tasktrackerbackend.repository;

import com.example.tasktrackerbackend.data.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
