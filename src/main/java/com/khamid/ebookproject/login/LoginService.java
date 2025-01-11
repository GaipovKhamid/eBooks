package com.khamid.ebookproject.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public LoginDTO registration(LoginDTO loginDTO) {
        LoginEntity loginEntity = new LoginEntity();

        loginEntity.setEmail(loginDTO.getEmail());
        loginEntity.setPassword(loginDTO.getPassword());

        loginRepository.save(loginEntity);
        loginDTO.setId(loginEntity.getId());

        return loginDTO;
    }

    public String login(LoginDTO loginDTO) {
        LoginEntity entity = new LoginEntity();

        if (entity.getEmail() == null || entity.getEmail().equals(loginDTO.getEmail())) {
            if (entity.getPassword() == null || entity.getPassword().equals(loginDTO.getPassword())) {
                return "hello";
            } else {
                return "error";
            }
        } else {
            return "error";
        }
    }


}
