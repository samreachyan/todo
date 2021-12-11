package me.todo.todo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String firstName;
    private String lastName;
    private String email;

//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "todo", cascade = CascadeType.ALL)
//    @JsonIgnoreProperties("todo")
//    private List<Todo> todoList = new ArrayList<>();

}
