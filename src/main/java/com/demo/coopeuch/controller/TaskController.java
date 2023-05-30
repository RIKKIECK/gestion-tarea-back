package com.demo.coopeuch.controller;

import com.demo.coopeuch.entity.Task;
import com.demo.coopeuch.repository.TaskRepository;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    public static final String CLASS_NAME = TaskController.class.getName();

    @Autowired
    private TaskRepository taskRepository;

    @CrossOrigin
    @PostMapping
    @Operation(summary = "Creación de tarea 'Created'")
    public ResponseEntity<Task> createTask(@Valid @RequestBody Task task, BindingResult bindingResult) {
        String _function = ".createTask";
        log.info(CLASS_NAME + _function + "::INICIO");
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Task createdTask = taskRepository.save(task);
        log.info(CLASS_NAME + _function + "::FINAL");
        return ResponseEntity.status(HttpStatus.OK).body(createdTask);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    @Operation(summary = "Listar tarea por ID 'Read' ")
    public ResponseEntity<Task> getTaskById(@PathVariable("id") Long taskId) {
        Optional<Task> optionalTask = taskRepository.findById(taskId);
        if (optionalTask.isPresent()) {
            return ResponseEntity.ok(optionalTask.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin
    @GetMapping
    @Operation(summary = "Listar todas las tarea 'getAllTasks' ")
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return ResponseEntity.ok(tasks);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    @Operation(summary = "actualizar ID 'Update' ")
    public ResponseEntity<Task> updateTask(@PathVariable("id") Long id, @Valid @RequestBody Task updatedTask,
                                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Task task = optionalTask.get();
        if (updatedTask.getDescription() != null) {
            task.setDescription(updatedTask.getDescription());
        }

        if (updatedTask.getCreationDate()!= null ) {
            task.setCreationDate(updatedTask.getCreationDate());
        }

        taskRepository.save(task);

        return ResponseEntity.ok(task);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    @Operation(summary = "Borrar tarea por ID 'Delete' ")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task == null) {
            return ResponseEntity.notFound().build();
        }

        taskRepository.delete(task);
        return ResponseEntity.noContent().build();
    }
}
