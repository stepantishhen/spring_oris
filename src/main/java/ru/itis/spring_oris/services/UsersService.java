package ru.itis.spring_oris.services;

import ru.itis.spring_oris.dto.UserDto;

import java.util.List;

public interface UsersService {
    List<UserDto> getAllUsers();
}