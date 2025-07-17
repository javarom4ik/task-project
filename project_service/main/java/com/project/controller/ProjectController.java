package com.project.controller;


import com.dto.ProjectDto;
import com.project.entity.Project;
import com.project.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public ResponseEntity<List<ProjectDto>> showAll() {
        return ResponseEntity.ok(projectService.showAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> showById(@PathVariable Long id) {
        return ResponseEntity.ok(projectService.showById(id));
    }

    @PostMapping
    public ResponseEntity<ProjectDto> createProject(@RequestBody Project project) {
       return ResponseEntity.ok(projectService.createProject(project));
    }
}
