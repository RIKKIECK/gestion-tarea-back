package com.demo.coopeuch;

import com.demo.coopeuch.controller.TaskController;
import com.demo.coopeuch.entity.Task;
import com.demo.coopeuch.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class CoopeuchApplicationTests {

	@Mock
	private TaskRepository taskRepository;

	@Mock
	private BindingResult bindingResult;

	@InjectMocks
	private TaskController taskController;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testCreateTask() {
		Task task = new Task();
		task.setDescription("Test task");

		when(bindingResult.hasErrors()).thenReturn(false);
		when(taskRepository.save(task)).thenReturn(task);

		ResponseEntity<Task> response = taskController.createTask(task, bindingResult);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(task, response.getBody());

		verify(taskRepository, times(1)).save(task);
	}

	@Test
	public void testGetTaskById() {
		Long taskId = 1L;
		Task task = new Task();
		task.setId(taskId);
		task.setDescription("Test task");

		when(taskRepository.findById(taskId)).thenReturn(Optional.of(task));

		ResponseEntity<Task> response = taskController.getTaskById(taskId);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(task, response.getBody());

		verify(taskRepository, times(1)).findById(taskId);
	}


}
