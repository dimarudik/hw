package com.example.hw2.controller;

import com.example.hw2.exception.AccountExistsException;
import com.example.hw2.model.LoginForm;
import com.example.hw2.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;
import java.util.logging.Logger;


@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/new")
    public String loginPage(WebRequest request, Model model){
        model.addAttribute("loginForm", new LoginForm());
        return "newuser";
    }

/*
    @GetMapping("/login")
    public String loginPage(Model model){
        model.addAttribute("loginForm", new LoginForm());
        model.addAttribute("newLoginForm", new LoginForm());
        return "login";
    }
*/

/*
    @PostMapping("/auth")
    public String auth(@Valid @ModelAttribute("loginForm") LoginForm loginForm, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("loginForm", loginForm);
            model.addAttribute("newLoginForm", new LoginForm());
            return "login";
        } else {
            Logger.getLogger(LoginController.class.getName()).info("auth with cred : " + loginForm.toString());
            return "index";
        }
    }
*/

    @PostMapping("/new")
    public String newUser(@Valid @ModelAttribute("loginForm") LoginForm loginForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("loginForm", loginForm);
            return "newuser";
        } else {
            try {
                if (LoginService.isAnonymous()) {
                    loginService.registerNewUserAccount(loginForm);
                } else {
                    Logger.getLogger(LoginController.class.getName()).info("User must be unauthorized");
                }
            } catch (AccountExistsException e) {
                e.printStackTrace();
                model.addAttribute("loginForm", loginForm);
                return "newuser";
            }
            return "login";
        }
    }

}
