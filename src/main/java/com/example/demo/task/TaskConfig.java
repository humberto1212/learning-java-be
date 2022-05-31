package com.example.demo.task;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskConfig {
    
    @Bean
    CommandLineRunner commandLineRunner(TaskRepository repository) {
        return args -> {
            Task Coffee = new Task("Buy Coffee", "20.05.2022", true);
            Task Java = new Task("Learn Java", "25.05.2022", true);
            Task Games = new Task("Play Games", "26.05.2022", true);
            Task Mama = new Task("Call Mama", "27.05.2022", true);

            repository.saveAll(
                List.of(Coffee, Java, Games, Mama)
            );
        };
    }
}
