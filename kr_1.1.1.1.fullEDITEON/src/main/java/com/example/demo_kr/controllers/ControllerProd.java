package com.example.demo_kr.controllers;

import com.example.demo_kr.service.AuthenticationService;
import com.example.demo_kr.service.ServiceProfile;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@Valid
@Controller
public class ControllerProd {
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("title", "Главная страница");
        return "home";
    }
    @GetMapping("/registration")
    public String registration(Model model){
        model.addAttribute("title", "Регистрация");
        return "Registration";
    }

    @GetMapping("/authorization")
    public String authorization(Model model){
        model.addAttribute("title", "Авторизация");
        return "authorization";
    }

    @GetMapping("/serials")
    public String serials(Model model){
        model.addAttribute("title", "Сериалы");
        return "serials";
    }

    @GetMapping("/films")
    public String films(Model model) {
        model.addAttribute("title", "Фильмы");
        return "films";
    }

    private final ServiceProfile Serviceprofile;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public String createProfile(
            @RequestParam @Valid String email,
            @RequestParam @Valid String password) {
        Serviceprofile.createProfile(email, password);
        return "good";
    }

    private final AuthenticationService AuthenticationService;
    public ControllerProd(ServiceProfile Serviceprofile,
                          com.example.demo_kr.service.AuthenticationService authenticationService) {
        this.Serviceprofile = Serviceprofile;
        this.AuthenticationService = authenticationService;
    }

    @PostMapping("/authorizationHome")
    public String login(
            @RequestParam @Valid String email,
            @RequestParam @Valid String password,
            Model model) {
        boolean isAuthenticated = AuthenticationService.authenticate(email, password);
        if (isAuthenticated) {
            return "authorizationHome";
        } else {
            return "Registration";
        }
    }
}