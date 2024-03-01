package ru.itis.spring_oris.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.spring_oris.dto.UserForm;
import ru.itis.spring_oris.services.SignUpService;

@Controller
public class SignUpController {

    @Autowired
    private SignUpService signUpService;

    @GetMapping("/signUpPage")
    public String getSignUpPage() {
        return "sign_up_page";
    }

    @PostMapping("/signUpPage")
    public String signUp(UserForm form){
        signUpService.addUser(form);
        return "redirect:/signUpPage";
    }
}
