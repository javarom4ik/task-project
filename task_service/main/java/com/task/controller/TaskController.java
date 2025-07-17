package com.task.controller;

import com.dto.TaskDto;
import com.task.entity.Task;
import com.task.service.TaskService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<TaskDto>> showAllTasks() {
        return ResponseEntity.ok(service.showAllTasks());
    }
//     @GetMapping("/{taskId}/project")
//     public ResponseEntity<Project> getProjectForTask(@PathVariable Long taskId) {
//         Project project = service.getProjectById(taskId);
//         return ResponseEntity.ok(project);
// }
    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> showTask(@PathVariable Long id) {
        return ResponseEntity.ok(service.showTask(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDto> updateTask(@RequestBody Task task, @PathVariable Long id) {
        return ResponseEntity.ok(service.updateTask(task, id));
    }

    @PostMapping
    public ResponseEntity<TaskDto> createTask(@RequestBody Task task) {
        return ResponseEntity.status(HttpStatus.CREATED)
        .body(service.createTask(task));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id){
        service.deleteTask(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT)
    .body("Task №" + id + " deleted successfully");
    }
}
