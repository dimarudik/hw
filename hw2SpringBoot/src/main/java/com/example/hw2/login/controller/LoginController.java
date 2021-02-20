package com.example.hw2.login.controller;

import com.example.hw2.login.exception.AccountExistsException;
import com.example.hw2.login.model.LoginForm;
import com.example.hw2.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;

//TODO добавьте комментарии
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/new")
    public String loginPage(WebRequest request, Model model){
        model.addAttribute("loginForm", new LoginForm());
        return "login/newuser";
    }

    @PostMapping("/new")
    public String newUser(@Valid @ModelAttribute("loginForm") LoginForm loginForm, BindingResult bindingResult, Model model) throws AccountExistsException {
        String warning = " user exists!";
        if (bindingResult.hasErrors()) {
            model.addAttribute("loginForm", loginForm);
            return "login/newuser";
        } else {
            if(!loginService.registerNewUserAccount(loginForm)) {
                throw new AccountExistsException(loginForm.getUsername() + warning);
            }
            return "redirect:/login";
        }
    }

    @ExceptionHandler(AccountExistsException.class)
    public String handleEmptyFilenameException(Model model, AccountExistsException accountExistsException){
        model.addAttribute("loginForm", new LoginForm());
        model.addAttribute("errorMessage", accountExistsException.getMessage());
        return "login/newuser";
    }


}
