package org.example.app.services;

import org.apache.log4j.Logger;
import org.example.web.model.LoginForm;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LoginService {

    private Logger logger = Logger.getLogger(LoginService.class);
    private final Set<LoginForm> repo = new HashSet<>();

    public boolean authenticate(LoginForm loginFrom) {
        logger.info("try auth with user-form: " + loginFrom);
        repo.forEach(logger::info);
        return (loginFrom.getUsername().equals("root") && loginFrom.getPassword().equals("123")) ||
                repo.stream()
                        .filter(i -> loginFrom.getUsername().equals(i.getUsername()))
                        .anyMatch(i -> loginFrom.getPassword().equals(i.getPassword()));
    }

    public void store(LoginForm login) {
        if ( !(login.getUsername().isEmpty() || login.getPassword().isEmpty()) ) {
            if ( !repo.stream().anyMatch(i -> login.getUsername().equals(i.getUsername())) ) {
                logger.info("Store new login: " + login);
                repo.add(login);
            } else {
                logger.warn("Username exists!");
            }
        } else {
            logger.warn("Can't save empty login!");
        }
    }



}
