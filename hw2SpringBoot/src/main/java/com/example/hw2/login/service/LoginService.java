package com.example.hw2.login.service;

import com.example.hw2.login.model.LoginForm;
import com.example.hw2.login.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements ILoginService<LoginForm> {

    @Autowired
    private InMemoryUserDetailsManager inMemoryUserDetailsManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean registerNewUserAccount(LoginForm loginForm) {
        if (inMemoryUserDetailsManager.userExists(loginForm.getUsername())) {
            return false;
        } else {
            inMemoryUserDetailsManager.createUser(User
                    .withUsername(loginForm.getUsername())
                    .password(passwordEncoder.encode(loginForm.getPassword()))
                    .roles("USER")
                    .build());
            return true;
        }
    }

    public static Boolean isAnonymous(){
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return null != authentication && ("anonymousUser").equals(authentication.getName());
    }

}
