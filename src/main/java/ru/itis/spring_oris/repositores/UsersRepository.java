package ru.itis.spring_oris.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.spring_oris.models.User;

public interface UsersRepository extends JpaRepository<User, Long> {
}
