package com.birse.ingester.controller;

import com.birse.ingester.domain.Text;
import com.birse.ingester.resource.Data;
import com.birse.ingester.service.TextService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller()
public class TextController {

    private static final Logger LOG = LoggerFactory.getLogger(TextController.class);


    private final TextService textService;

    @Autowired
    TextController(final TextService textService) {
        this.textService = textService;
    }

    @GetMapping("/text")
    public String get(Model model) {
        model.addAttribute("data", new Data());
        return "text";
    }

    @PostMapping("/text")
    public String addData(@Valid Data data, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "text";
        }

        textService.send(data);
        return "index";
    }



}
