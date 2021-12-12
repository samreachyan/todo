package me.todo.todo.entity;

import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;

import java.util.Optional;

@Component
public class TodoValidator {
    /**
     * Validate value Todo
     *
     * @param todo
     * @return
     */
    public boolean isValid(Todo todo) {
        return Optional.ofNullable(todo)
                .filter(t -> !StringUtils.isEmpty(t.getDetail())) // Kiểm tra title khác rỗng
                .filter(t -> !StringUtils.isEmpty(t.getDetail())) // Kiểm tra detail khác rỗng
                .isPresent(); // Trả về true nếu hợp lệ, ngược lại false
    }

}