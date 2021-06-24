package com.gox.http2ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController()
@RequestMapping("message")
public class GreetingController {

    private SimpMessagingTemplate template;

    @Autowired
    public GreetingController(SimpMessagingTemplate template) {
        this.template = template;
    }

    @GetMapping
    public String sendMsg() {
        this.template.convertAndSend("/topic", "{ \"payload\": \"hello there " + new Date() + "\" }");
        return "OK";
    }
}