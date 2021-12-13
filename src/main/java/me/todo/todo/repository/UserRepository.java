package me.todo.todo.repository;

import me.todo.todo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findById(int userId);

    @Query("SELECT u FROM User u WHERE u.username = ?1")
    public User findByUsername(String username);
}
