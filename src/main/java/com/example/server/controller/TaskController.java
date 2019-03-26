package com.example.server.controller;

import com.example.server.dto.TaskDto;
import com.example.server.repo.Project;
import com.example.server.repo.ProjectRepository;
import com.example.server.repo.Task;
import com.example.server.repo.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping
    public List<TaskDto> getTasks() {
        return taskRepository.findAll().stream()
                .map(TaskDto::toDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public TaskDto updateTask(@PathVariable("id") Long id, @RequestBody TaskDto dto) {
        Project project = projectRepository.findById(dto.getProjectId()).orElse(null);
        Task task = TaskDto.toTask(dto, project);
        this.taskRepository.save(task);
        return dto;
    }
}
