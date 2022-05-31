package com.example.demo.task;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Task {

    @Id
    @SequenceGenerator(
        name = "task_sequence",
        sequenceName = "task_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "task_sequence"
    )
    private Long id;
    private String text;
    private String day;
    private Boolean reminder;

 /*    public Task(Long id, String text, String day, Boolean reminder) {
        this.id = id;
        this.text = text;
        this.day = day;
        this.reminder = reminder;
    } */

    public Task() { // I should always have a default constructor
    }

    public Task(String text, String day, Boolean reminder) {
        this.text = text;
        this.day = day;
        this.reminder = reminder;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Boolean getReminder() {
        return reminder;
    }
 
    public void setReminder(Boolean reminder) {
        this.reminder = reminder;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", day='" + day + '\'' +
                ", reminder=" + reminder +
                '}';
    }

}