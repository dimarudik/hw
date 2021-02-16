package com.example.hw2.service;

import com.example.hw2.exception.AccountExistsException;
import com.example.hw2.model.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class LoginService implements ILoginService<LoginForm> {

    @Autowired
    private InMemoryUserDetailsManager inMemoryUserDetailsManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerNewUserAccount(LoginForm loginForm) throws AccountExistsException {
        String warning = " user exists!";
        if (inMemoryUserDetailsManager.userExists(loginForm.getUsername())) {
            Logger.getLogger(LoginService.class.getName()).warning(loginForm.getUsername() + warning);
            throw new AccountExistsException(loginForm.getUsername() + warning);
        } else {
            inMemoryUserDetailsManager.createUser(User
                    .withUsername(loginForm.getUsername())
                    .password(passwordEncoder.encode(loginForm.getPassword()))
                    .roles("USER")
                    .build());
            Logger.getLogger(LoginService.class.getName()).info("New user : " + loginForm.toString());
        }
    }

    public static Boolean isAnonymous(){
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return null != authentication && ("anonymousUser").equals(authentication.getName());
    }

}
