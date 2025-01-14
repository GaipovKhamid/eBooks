package com.khamid.ebookproject.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private LoginRepository loginRepository;

    @GetMapping("/registration")
    public String userReg() {
        return "registrationPage";
    }

    @PostMapping("/registration")
    public String regPost(@ModelAttribute LoginDTO dto) {
        loginService.registration(dto);
        return "redirect:/hello";
    }

    @GetMapping("/signin")
    public String signIn() {
        return "signInPage";
    }

    @PostMapping("/signin")
    public String signIn(@ModelAttribute LoginDTO loginDTO) {
        if (loginService.isAuth(loginDTO)) {
            return "redirect:/hello";
        }
        return "signInPage";
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }


}
