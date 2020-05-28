package edu.aueb.cs.istos.giarengkinbousoulas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping(value = "/")
    public String home(){
        return "test";
    }

    @Controller
    static class FaviconController {
        @RequestMapping("favicon.svg")
        String favicon() {
            return "forward:/resources/images/favicon.svg";
        }
    }
}
