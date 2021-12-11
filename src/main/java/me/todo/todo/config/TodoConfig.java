package me.todo.todo.config;

import me.todo.todo.model.TodoValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TodoConfig {

    @Bean
    public TodoValidator validator() {
        return new TodoValidator();
    }

}
