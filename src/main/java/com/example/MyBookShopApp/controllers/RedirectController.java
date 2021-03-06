package com.example.MyBookShopApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/books/recent.html")
    public ModelAndView redirectWithUsingForwardPrefixResent(ModelMap model) {
        model.addAttribute("attribute", "forwardWithForwardPrefixResent");
        return new ModelAndView("forward:/recent", model);
    }

    @GetMapping("/books/popular.html")
    public ModelAndView redirectWithUsingForwardPrefixPopular(ModelMap model) {
        model.addAttribute("attribute", "forwardWithForwardPrefixPopular");
        return new ModelAndView("forward:/popular", model);
    }

    @GetMapping("/authors/index.html")
    public ModelAndView redirectWithUsingForwardPrefixAuthors(ModelMap model) {
        model.addAttribute("attribute", "forwardWithForwardPrefixAuthors");
        return new ModelAndView("forward:/authors", model);
    }

    @GetMapping("/postponed.html")
    public ModelAndView redirectWithUsingForwardPrefixPostponed(ModelMap model) {
        model.addAttribute("attribute", "forwardWithForwardPrefixPostponed");
        return new ModelAndView("forward:/postponed", model);
    }

    @GetMapping("/cart.html")
    public ModelAndView redirectWithUsingForwardPrefixCart(ModelMap model) {
        model.addAttribute("attribute", "forwardWithForwardPrefixCart");
        return new ModelAndView("forward:/cart", model);
    }

    @GetMapping("/signin.html")
    public ModelAndView redirectWithUsingForwardPrefixSignin(ModelMap model) {
        model.addAttribute("attribute", "forwardWithForwardPrefixSignin");
        return new ModelAndView("forward:/signin", model);
    }

    @GetMapping("/about.html")
    public ModelAndView redirectWithUsingForwardPrefixAbout(ModelMap model) {
        model.addAttribute("attribute", "forwardWithForwardPrefixAbout");
        return new ModelAndView("forward:/about", model);
    }

    @GetMapping("/faq.html")
    public ModelAndView redirectWithUsingForwardPrefixFAQ(ModelMap model) {
        model.addAttribute("attribute", "forwardWithForwardPrefixFAQ");
        return new ModelAndView("forward:/faq", model);
    }

    @GetMapping("/contacts.html")
    public ModelAndView redirectWithUsingForwardPrefixContacts(ModelMap model) {
        model.addAttribute("attribute", "forwardWithForwardPrefixContacts");
        return new ModelAndView("forward:/contacts", model);
    }

    @GetMapping("/documents/index.html")
    public ModelAndView redirectWithUsingForwardPrefixDocuments(ModelMap model) {
        model.addAttribute("attribute", "forwardWithForwardPrefixDocuments");
        return new ModelAndView("forward:/documents", model);
    }

}
