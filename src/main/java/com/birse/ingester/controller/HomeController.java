package com.birse.ingester.controller;

import com.birse.ingester.resource.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller()
public class HomeController {

    @GetMapping("/")
    public String get() {
        return "index";
    }
}
