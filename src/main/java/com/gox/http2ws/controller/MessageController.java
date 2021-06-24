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
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private static Logger log = LoggerFactory.getLogger(MessageController.class);
    private SimpMessagingTemplate template;

    @Autowired
    public MessageController(SimpMessagingTemplate template) {
        this.template = template;
    }

    @PostMapping(path = "/message", consumes = "application/json", produces = "application/json")
    public Message sendMsg(@RequestBody MessageParamBody messageBody) {
        Message message = new Message(messageBody.getPayload());
        log.info("Request from HTTP client " + message);
        this.template.convertAndSend("/topic" + messageBody.getDestinationTopic(), message);
        return message;
    }

    @MessageMapping("/hello")
    @SendTo("/topic/kek")
    public Message greeting(Message message) throws Exception {
        log.info("Message from WS client " + message);
        return message;
    }
}