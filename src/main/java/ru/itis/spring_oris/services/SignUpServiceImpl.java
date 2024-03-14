package ru.itis.spring_oris.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.spring_oris.dto.UserForm;
import ru.itis.spring_oris.models.Role;
import ru.itis.spring_oris.models.User;
import ru.itis.spring_oris.repositores.UsersRepository;

@Component
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void addUser(UserForm form) {
        User user = User.builder()
                .email(form.getEmail())
                .password(passwordEncoder.encode(form.getPassword()))
                .firstName(form.getFirstname())
                .lastName(form.getLastname())
                .confirmed("CONFIRMED")
                .role(Role.USER)
                .build();
        usersRepository.save(user);
    }
}