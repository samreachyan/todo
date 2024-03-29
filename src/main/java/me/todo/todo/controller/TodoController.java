package me.todo.todo.controller;

import me.todo.todo.entity.Todo;
import me.todo.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class TodoController {
    @Autowired
    private TodoService todoService;


    /*
    @RequestParam dùng để đánh dấu một biến là request param trong request gửi lên server.
    Nó sẽ gán dữ liệu của param-name tương ứng vào biến
     */
//    @GetMapping("/home")
//    public String getHome() {
//        return "home";
//    }

    @GetMapping("/welcome")
    public String getWelcome() {
        return "welcome";
    }

    @GetMapping("/")
    public String getWelcome2() {
        return "welcome";
    }

    @GetMapping("/home")
    public String getHome() {
        return "home";
    }


    @GetMapping("/listTodo")
    public String index(Model model, @RequestParam(value = "limit", required = false) Integer limit) {
        // Trả về đối tượng todoList.
        model.addAttribute("todoList", todoService.findAll(limit));
        // Trả về template "listTodo.html"
        return "listTodo";
    }

    @GetMapping("/addTodo")
    public String addTodo(Model model) {
        model.addAttribute("todo", new Todo());
        return "addTodo";
    }

    /*
    @ModelAttribute đánh dấu đối tượng Todo được gửi lên bởi Form Request
     */
    @PostMapping("/addTodo")
    public String addTodo(@Valid @ModelAttribute Todo todo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addTodo";
        }
        else {
            todoService.add(todo);
            return "success";
        }
//        return Optional.ofNullable(todoService.add(todo))
//                .map(t -> "success") // Trả về success nếu save thành công
//                .orElse("failed"); // Trả về failed nếu không thành công
    }
}
