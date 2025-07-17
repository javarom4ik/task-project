package com.project.mapper;

import java.util.List;

import com.dto.ProjectDto;
import com.project.entity.Project;

public class ProjectDtoMapper {

    public static ProjectDto toDto(Project project) {
        return new ProjectDto(project.getId(), project.getName());
    }

    public static List<ProjectDto> toDto(List<Project> projects) {
        return projects.stream()
                .map(project -> ProjectDtoMapper.toDto(project))
                .toList();
    }
}
