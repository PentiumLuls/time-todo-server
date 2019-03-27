package com.example.server.dto;

import com.example.server.repo.Project;
import com.example.server.repo.Task;

public class TaskDto {

    private Long id;
    private String name;
    private Long projectId;
    private int priority;
    private String expirationDate;
    private String duration;

    public static Task toTask(TaskDto dto, Project project) {
        Task task = new Task();
        task.setId(dto.getId());
        task.setName(dto.getName());
        task.setProject(project);
        task.setPriority(dto.getPriority());
        task.setExpirationDate(dto.getExpirationDate());
        task.setDuration(dto.getDuration());
        return task;
    }

    public static TaskDto toDto(Task task) {
        TaskDto dto = new TaskDto();
        dto.setId(task.getId());
        dto.setName(task.getName());
        dto.setProjectId(task.getProject().getId());
        dto.setPriority(task.getPriority());
        dto.setExpirationDate(task.getExpirationDate());
        dto.setDuration(task.getDuration());
        return dto;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
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
