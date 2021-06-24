package com.gox.http2ws.dto;

public class MessageParamBody {

    private String destinationTopic;
    private String payload;

    public MessageParamBody() {
    }

    public String getDestinationTopic() {
        return destinationTopic;
    }

    public void setDestinationTopic(String destinationTopic) {
        this.destinationTopic = destinationTopic;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }
}
