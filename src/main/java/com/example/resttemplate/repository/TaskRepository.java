package com.example.resttemplate.repository;

import com.example.resttemplate.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
