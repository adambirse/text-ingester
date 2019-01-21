package com.birse.ingester.controller;

import com.birse.ingester.resource.Data;
import com.birse.ingester.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController()
@RequestMapping("/text")
public class TextController {

    private final TextService textService;

    @Autowired
    TextController(final TextService textService) {
        this.textService = textService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Data data) {
        textService.send(data);
        return ResponseEntity.ok(null);
    }
}
