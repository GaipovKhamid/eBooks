package com.khamid.ebookproject.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class LoginController {


    @Autowired
    private LoginService loginService;

    @GetMapping("/registration")
    public String userReg(@ModelAttribute LoginDTO user) {
        loginService.registration(user);
        return "registrationPage";
    }

    @GetMapping("/signin")
    public String userSignin(@ModelAttribute LoginDTO user) {
        loginService.login(user);
        return "signInPage";
    }
}
