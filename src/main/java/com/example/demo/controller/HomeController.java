package com.example.demo.controller;

import com.example.demo.entity.Reader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Reader reader, Model model){
        model.addAttribute(reader);
        return "profile";
    }
}
