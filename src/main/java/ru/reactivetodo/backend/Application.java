package ru.reactivetodo.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import ru.reactivetodo.backend.model.Task;
import ru.reactivetodo.backend.repository.TaskRepository;

@SpringBootApplication
public class Application {
    @Autowired
    private TaskRepository taskRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    @Profile("develop")
    public CommandLineRunner initData() {
        return args -> {
            for (int i = 0; i < 20; i++) {
                taskRepository.save(Task.builder()
                        .description("task" + i)
                        .checked(false)
                        .build());
            }
        };
    }
}
