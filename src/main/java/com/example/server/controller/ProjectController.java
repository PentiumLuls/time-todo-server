package com.example.server.controller;

import com.example.server.repo.Project;
import com.example.server.repo.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
@CrossOrigin(origins = "http://localhost:4200")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping
    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public Project getProjectByName(@PathVariable("name") String name) {
        return projectRepository.findByName(name);
    }
}
