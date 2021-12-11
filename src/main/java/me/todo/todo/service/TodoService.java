package me.todo.todo.service;

import me.todo.todo.model.Todo;
import me.todo.todo.model.TodoValidator;
import me.todo.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    /**
     * Lấy ra danh sách List<Todo>
     *
     * @param limit - Giới hạn số lượng lấy ra
     * @return Trả về danh sách List<Todo> dựa theo limit, nếu limit == null thì trả findAll()
     */
    public List<Todo> findAll(Integer limit) {
        return Optional.ofNullable(limit)
                .map(value -> todoRepository.findAll(PageRequest.of(0, value)).getContent())
                .orElseGet(() -> todoRepository.findAll());
    }

    /**
     * Thêm một Todo mới vào danh sách công việc cần làm
     *
     * @return Trả về đối tượng Todo sau khi lưu vào DB, trả về null nếu không thành công
     */
    public Todo add(Todo todo) {
        return todoRepository.save(todo);
    }

    public void remove(Long id) {
        todoRepository.deleteById(id);
    }

    public Todo getByIdTodo(Long id) {
        return todoRepository.findById(id).get();
    }

    public List<Todo> getAllTodo() {
        return todoRepository.findAll();
    }

    public void addNewTodo(Todo todo) {
        todoRepository.save(todo);
    }


}
