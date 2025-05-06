package com.example.tasktrackerbackend.repository;

import com.example.tasktrackerbackend.data.Task;
import com.example.tasktrackerbackend.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long> {
}
