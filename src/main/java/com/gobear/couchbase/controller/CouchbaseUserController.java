package com.gobear.couchbase.controller;

import com.gobear.couchbase.service.CouchbaseUserService;
import com.gobear.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CouchbaseUserController {

    @Autowired
    private CouchbaseUserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping("/user/save")
    @ResponseBody
    public String saveToken(@RequestParam String id, @RequestParam String username,
                            @RequestParam String password, @RequestParam String role) {
        UserInfo user = new UserInfo(id, username, passwordEncoder.encode(password), role);
        userService.save(user);
        return "Save success";
    }

    @RequestMapping("/user/findbyuname")
    @ResponseBody
    public UserInfo findById(@RequestParam String username) {
        UserInfo user = userService.findByUsername(username);
        return user;
    }
}
