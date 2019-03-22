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
@RequestMapping("/projects")
@CrossOrigin(origins = "http://localhost:4200")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private TaskRepository taskRepository;

    @GetMapping
    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public Project getProjectByName(@PathVariable("name") String name) {
        return projectRepository.findByName(name);
    }

    @RequestMapping(value = "/{name}/tasks", method = RequestMethod.GET)
    public List<TaskDto> getTasksByProjectName(@PathVariable("name") String name) {
        Project project = projectRepository.findByName(name);
        return taskRepository.findAllByProjectId(project.getId()).stream()
                .map(TaskDto::toDto)
                .collect(Collectors.toList());
    }
}
