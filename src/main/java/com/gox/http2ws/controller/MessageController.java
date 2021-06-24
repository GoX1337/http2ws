package com.gox.http2ws.controller;

import com.gox.http2ws.dto.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController()
@RequestMapping("message")
public class MessageController {

    private SimpMessagingTemplate template;

    @Autowired
    public MessageController(SimpMessagingTemplate template) {
        this.template = template;
    }

    @GetMapping
    public Message sendMsg() {
        Message msg = new Message("Hi there");
        this.template.convertAndSend("/topic", msg);
        return msg;
    }
}