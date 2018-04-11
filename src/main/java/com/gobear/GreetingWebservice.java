package com.gobear;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GreetingWebservice {

    @RequestMapping("/greeting")
    @ResponseBody
    public String sayHello() {
        return "Logn success!Greeting from GB";
    }
}
