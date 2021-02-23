package com.example.MyBookShopApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RedirectController {

    @GetMapping("/index.html")
    public ModelAndView redirectWithUsingForwardPrefixMain(ModelMap model) {
        model.addAttribute("attribute", "forwardWithForwardPrefixMain");
        return new ModelAndView("forward:/", model);
    }

    @GetMapping("/genres/index.html")
    public ModelAndView redirectWithUsingForwardPrefixGenres(ModelMap model) {
        model.addAttribute("attribute", "forwardWithForwardPrefixGenres");
        return new ModelAndView("forward:/genres", model);
    }

    @GetMapping("/authors/index.html")
    public ModelAndView redirectWithUsingForwardPrefixAuthors(ModelMap model) {
        model.addAttribute("attribute", "forwardWithForwardPrefixAuthors");
        return new ModelAndView("forward:/authors", model);
    }

}
