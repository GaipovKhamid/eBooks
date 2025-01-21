package com.khamid.ebookproject.login;

public interface LoginService {
     LoginDTO registration(LoginDTO loginDTO);
     boolean isAuth(LoginDTO loginDTO);
}
