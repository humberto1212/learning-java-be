package com.example.demo.task;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT s FROM Task s WHERE s.text = ?1")
    Optional<Task> findTaskByText(String text);
}
