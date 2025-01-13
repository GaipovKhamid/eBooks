package com.khamid.ebookproject.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

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

    public boolean isAuth(LoginDTO loginDTO) {
        Optional<LoginEntity> loginEntity =
                loginRepository.findByEmail(loginDTO.getEmail());

        if (loginEntity.isPresent()) {
            if (StringUtils.hasText(loginEntity.get().getEmail()) &&
                    loginEntity.get().getEmail().equals(loginDTO.getEmail())) {
                if (StringUtils.hasText(loginEntity.get().getPassword())
                        && loginEntity.get().getPassword().equals(loginDTO.getPassword())) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}
