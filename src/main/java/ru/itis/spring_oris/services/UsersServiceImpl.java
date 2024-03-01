package ru.itis.spring_oris.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.spring_oris.dto.UserDto;
import ru.itis.spring_oris.repositores.UsersRepository;

import java.util.List;

import static ru.itis.spring_oris.dto.UserDto.from;

@Component
public class UsersServiceImpl implements UsersService{

    @Autowired
    private UsersRepository usersRepository;
    @Override
    public List<UserDto> getAllUsers() {
        return from(usersRepository.findAll());
    }
}