package com.example.server.dto;

import com.example.server.repo.Project;
import com.example.server.repo.Task;

public class TaskDto {

    private Long id;
    private String name;
    private Long projectId;

    public static Task toTask(TaskDto dto, Project project) {
        Task task = new Task();
        task.setId(dto.getId());
        task.setName(dto.getName());
        task.setProject(project);
        return task;
    }

    public static TaskDto toDto(Task task) {
        TaskDto dto = new TaskDto();
        dto.setId(task.getId());
        dto.setName(task.getName());
        dto.setProjectId(task.getProject().getId());
        return dto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
