package com.gox.http2ws.controller;

import com.gox.http2ws.dto.Message;
import com.gox.http2ws.dto.MessageParamBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MessageController {

    private Logger log = LoggerFactory.getLogger(MessageController.class);

    private SimpMessagingTemplate template;

    @Autowired
    public MessageController(SimpMessagingTemplate template) {
        this.template = template;
    }

    @PostMapping("/message")
    public Message sendMsg(@RequestBody MessageParamBody messageBody) {
        Message msg = new Message("Hi there");
        this.template.convertAndSend("/topic/kek", msg);
        return msg;
    }

    @MessageMapping("/hello")
    @SendTo("/topic/kek")
    public Message greeting(Message message) throws Exception {
        log.info("message from client " + message);
        return message;
    }
}