package com.demo.coopeuch.repository;

import com.demo.coopeuch.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}

