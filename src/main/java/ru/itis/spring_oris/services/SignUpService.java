package ru.itis.spring_oris.services;

import ru.itis.spring_oris.dto.UserForm;

public interface SignUpService {
    public void addUser(UserForm form);
}