package com.example.hw2.common.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import static com.example.hw2.common.repository.Constants.*;

/*
Сделано по примеру
https://www.codejava.net/frameworks/spring-boot/spring-boot-error-handling-guide
*/
//TODO добавьте комментарии (включая ссылку, описать)
// строки сообщений в константы
//    Done
@Controller
public class CustomErrorController implements ErrorController {

    // Перенаправляем на страницу ошибки в зависимости от кода ошибки
    @GetMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        String errorPage = "error"; // default

        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());

            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                model.addAttribute("errorMessage", M_PAGENOTFOUND);
                errorPage = "error/404";

            } else if (statusCode == HttpStatus.FORBIDDEN.value()) {
                model.addAttribute("errorMessage", M_ACCESSDENIED);
                errorPage = "error/403";

            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                model.addAttribute("errorMessage", M_SERVERERROR);
                errorPage = "error/500";

            }
        }

        return errorPage;
    }

    // Дефолтная страничка ошибки
    @Override
    public String getErrorPath() {
        return "/error";
    }

}
