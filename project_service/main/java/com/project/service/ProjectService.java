package com.project.service;


import com.project.entity.Project;
import com.project.mapper.ProjectDtoMapper;
import com.project.repository.ProjectRepository;
import org.springframework.stereotype.Service;
import com.dto.ProjectDto;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<ProjectDto> showAll() {
        return ProjectDtoMapper.toDto(projectRepository.findAll());
    }

    public ProjectDto showById(Long id) {
        return ProjectDtoMapper.toDto(projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project with id " + id + " not found")));
    }

    public ProjectDto createProject(Project project) {
        return ProjectDtoMapper.toDto(projectRepository.save(project));
    }
}
