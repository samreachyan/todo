package me.todo.todo.repository;

import me.todo.todo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findById(int userId);

    @Query("SELECT u FROM User u WHERE u.username = ?1")
    User findByUsername(String username);
}
