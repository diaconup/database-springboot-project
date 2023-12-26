package net.javaguides.Project.repository;


import net.javaguides.Project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT u.* FROM user u WHERE u.email = ?1 AND u.password = ?2", nativeQuery = true)
    List<User> getUserByEmailPassword(String email, String password);
}
