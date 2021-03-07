package com.example.MyBookShopApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class GenresController {

    @GetMapping("/genres")
    public String genresPage(HttpServletRequest httpServletRequest, Model model){
        model.addAttribute("servletPath", httpServletRequest.getServletPath());
        return "/genres/index";
    }

}
