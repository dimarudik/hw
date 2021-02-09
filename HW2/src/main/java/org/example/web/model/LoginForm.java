package org.example.web.model;

import javax.validation.constraints.NotEmpty;

public class LoginForm implements Comparable<LoginForm>{

    @NotEmpty
    private String username;
    @NotEmpty
    private String password;

    public LoginForm(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public LoginForm() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginForm{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoginForm loginForm = (LoginForm) o;

        return username != null ? username.equals(loginForm.username) : loginForm.username == null;
    }

    @Override
    public int hashCode() {
        return username != null ? username.hashCode() : 0;
    }

    @Override
    public int compareTo(LoginForm loginForm) {
        //return loginForm.getUsername().hashCode();
        return loginForm.hashCode();
    }

}
