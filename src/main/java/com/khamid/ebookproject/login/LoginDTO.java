package com.khamid.ebookproject.login;

import lombok.Getter;
import lombok.Setter;

public class LoginDTO {
    private Long id;
    private String email;
    private String password;

    @Override
    public String toString() {
        return "LoginDTO{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginDTO(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public LoginDTO() {
    }
}
