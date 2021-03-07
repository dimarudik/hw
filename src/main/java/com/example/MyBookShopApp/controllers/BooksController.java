package com.example.MyBookShopApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class BooksController {

    @GetMapping("/recent")
    public String recentPage(HttpServletRequest httpServletRequest, Model model){
        model.addAttribute("servletPath", httpServletRequest.getServletPath());
        return "/books/recent";
    }

    @GetMapping("/popular")
    public String popularPage(HttpServletRequest httpServletRequest, Model model){
        model.addAttribute("servletPath", httpServletRequest.getServletPath());
        return "/books/popular";
    }

}
