package ru.itis.spring_oris.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignInController {
    @GetMapping("/signIn")
    public  String getSingInPAge() {return "sign_in_page";}
}