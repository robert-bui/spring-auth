/*
package com.gobear.security.controller;

import com.gobear.security.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {


    @Autowired
    private LoginService loginService;

    @RequestMapping("/")
    public String home() {
        return "redirect:/login";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(HttpServletResponse httpServletResponse, String username, String password, String redirect, Model model) {

        if (!loginService.isAuthenSuccess(username, password, httpServletResponse)) {
            model.addAttribute("error", "Invalid username or password!");
            return "login";
        }


        return "redirect:" + redirect;
    }
}
*/
