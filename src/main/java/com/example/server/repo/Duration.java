package com.example.server.repo;

import javax.persistence.*;

@Entity
@Table(schema = "timemanager")
public class Duration {

    @Id
    @GeneratedValue
    private Long id;

    private TimesMeasure timeMeasure;
    private int amount;

    @OneToOne
    @MapsId
    private Task task;

    public Duration() {
    }

    public Duration(TimesMeasure timeMeasure, int amount) {
        this.timeMeasure = timeMeasure;
        this.amount = amount;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public TimesMeasure getTimeMeasure() {
        return timeMeasure;
    }

    public void setTimeMeasure(TimesMeasure timeMeasure) {
        this.timeMeasure = timeMeasure;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
