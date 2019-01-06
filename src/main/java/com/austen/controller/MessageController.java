package com.austen.controller;

import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class MessageController {
    @Resource
    private MqttPahoMessageHandler mqtt;

    @RequestMapping(value="/send")
    public void sendMessage(){
        Message<String> message = MessageBuilder.withPayload("==========1111111111111111111111111=========").setHeader(MqttHeaders.TOPIC, "topicTest1").build();
        mqtt.handleMessage(message);
        System.out.println("成功");
    }
}

