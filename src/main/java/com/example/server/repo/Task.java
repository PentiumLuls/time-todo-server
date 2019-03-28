package com.example.server.repo;

import lombok.NonNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema = "timemanager", name = "task")
public class Task {

    @Id
    @GeneratedValue
    @Column(name = "task_id")
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn
    @NonNull
    private Project project;

    private String duration;

    private int priority;

    private String startDate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "task")
    private List<Tag> tags;

    public Task() {
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
