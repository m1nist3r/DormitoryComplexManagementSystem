package com.m1nist3r.dormitory.web.application.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DormitoryMainActivityWebController {

    @GetMapping(value = {"/", "/index"})
    public String getHomePage(Model model) {
        return "index";
    }

    @GetMapping(value = "/login")
    public String getLoginPage(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken)) {
            return "redirect:/index";
        }
        return "login";
    }

    @GetMapping(value = "/logout")
    public String getLogoutPage(Model model) {
        return "login";
    }


}
