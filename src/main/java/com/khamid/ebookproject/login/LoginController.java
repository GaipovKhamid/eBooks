package com.khamid.ebookproject.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class LoginController {

    @Autowired
    private LoginServiceImpl loginService;
    @Autowired
    private LoginRepository loginRepository;

    @GetMapping("/registration")
    public String userReg() {
        return "registrationPage";
    }

    @PostMapping("/registration")
    public String regPost(LoginDTO loginDTO) {
        loginService.registration(loginDTO);
        return "hello";
    }

    @GetMapping("/signin")
    public String signIn() {
        return "signInPage";
    }

    @PostMapping("/signin")
    public String signIn(@ModelAttribute LoginDTO loginDTO) {
        if (loginService.isAuth(loginDTO)) {
            return "hello";
        }
        return "signInPage";
    }

    @GetMapping("/home")
    public String home() {
        return "homePage";
    }


    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }


}
