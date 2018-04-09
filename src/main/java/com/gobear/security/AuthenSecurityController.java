package com.gobear.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sec")
public class AuthenSecurityController {

    @RequestMapping("/autheninfo")
    @ResponseBody
    public String getInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.toString();
    }
}
