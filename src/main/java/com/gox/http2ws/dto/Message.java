package com.gox.http2ws.dto;

import java.util.Date;

public class Message {

    private String payload;
    private Date date;

    public Message(String payload) {
        this.payload = payload;
        this.date = new Date();
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
