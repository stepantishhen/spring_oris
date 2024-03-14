package ru.itis.spring_oris.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.spring_oris.models.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}