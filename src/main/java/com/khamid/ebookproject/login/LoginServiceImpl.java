package com.khamid.ebookproject.login;

import com.khamid.ebookproject.exception.DuplicateExeption;
import com.khamid.ebookproject.exception.ResouceNotFound;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class LoginServiceImpl implements LoginService {


    private final LoginRepository loginRepository;
    public LoginServiceImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }


    public LoginDTO registration(LoginDTO loginDTO) {
        LoginEntity loginEntity = new LoginEntity();

        if (loginRepository.existsByEmail(loginDTO.getEmail())) {
            throw new DuplicateExeption("Email already in use");
        }

        loginEntity.setEmail(loginDTO.getEmail());
        loginEntity.setPassword(loginDTO.getPassword());

        loginRepository.save(loginEntity);
        loginDTO.setId(loginEntity.getId());

        return loginDTO;
    }

//    anydesk
// mapper todo:

    public boolean isAuth(LoginDTO loginDTO) {
        /// Resource Not found qaytarish kerak
        var loginEntity = loginRepository.findByEmail(loginDTO.getEmail()).orElseThrow(() -> new ResouceNotFound("Email not found"));

        if (StringUtils.hasText(loginEntity.getEmail()) && loginEntity.getEmail().equals(loginDTO.getEmail())) {
            if (StringUtils.hasText(loginEntity.getPassword()) && loginEntity.getPassword().equals(loginDTO.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
