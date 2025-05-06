package com.example.tasktrackerbackend.service;

import com.example.tasktrackerbackend.data.Task;
import com.example.tasktrackerbackend.data.User;
import com.example.tasktrackerbackend.repository.TaskRepository;
import com.example.tasktrackerbackend.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = {TaskService.class})
@AutoConfigureDataJpa
@AutoConfigureTestEntityManager
@AutoConfigureTestDatabase
@EnableJpaRepositories(basePackages = "com.comfone.pulse.sales.item.repository")
@EntityScan(basePackages = "com.comfone.pulse.sales.item.data")
@TestPropertySource(locations = {"classpath:application.yml"})
@Transactional
public class TaskServiceTest {
    @Mock
    private TaskRepository taskRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private TaskService taskService;

    private User user;
    private Task task;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        user = new User();
        user.setId(1L);
        user.setUsername("testuser");
        user.setPassword("password");

        task = new Task();
        task.setTitle("Test Task");
        task.setDescription("Test Description");
        task.setStatus("OPEN");
    }

    @Test
    public void testCreateTask() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        when(taskRepository.save(any(Task.class))).thenReturn(task);


        Task createdTask = taskService.createTask(task, 1L);

        // Überprüfe, ob die Task korrekt erstellt wurde
        assertNotNull(createdTask);
        assertEquals("Test Task", createdTask.getTitle());
        assertEquals("Test Description", createdTask.getDescription());
        assertEquals("OPEN", createdTask.getStatus());

        // Überprüfe, ob das Repository aufgerufen wurde
        verify(taskRepository, times(1)).save(any(Task.class));
    }

}
