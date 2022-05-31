package com.example.demo.task;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasks() {
		return taskRepository.findAll();
	}

    public void addNewTask(Task task) {
        Optional<Task> taskOptional = taskRepository
        .findTaskByText(task.getText());
        if (taskOptional.isPresent()){
            throw new IllegalStateException("task taken");
        }

        taskRepository.save(task);
    }

    public void deleteTask(Long taskId) {
        boolean exists = taskRepository.existsById(taskId);
        if (!exists) {
            throw new IllegalStateException("ID does not exists");
        }
        taskRepository.deleteById(taskId);
    }

    @Transactional
    public void updateTask(Long taskId, String text, String day, Boolean reminder){
        Task task = taskRepository.findById(taskId)
        .orElseThrow(() -> new IllegalStateException("Task id does not exists"));

        if (text != null && text.length() > 0 && !Objects.equals(task.getText(), text)){
            task.setText(text);
        }

        if (day != null && day.length() > 0 && !Objects.equals(task.getDay(), day)){
            task.setDay(day);
        }

        if (reminder != null && !Objects.equals(task.getReminder(), reminder)){
            task.setReminder(reminder);
        }
    }
    
}