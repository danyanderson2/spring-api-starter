package com.codewithmosh.store.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  //bean, object managed by spring, this class is henced marked as a bean a spring object
public class HomeController {
    @RequestMapping("/")  // maps the root URL to this method, when a user accesses the root URL, this method will be invoked
    public String index(Model model){
        model.addAttribute("name", "Dany");
        return "index";
    }
} 
