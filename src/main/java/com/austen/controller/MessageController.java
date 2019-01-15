package com.austen.controller;

import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class MessageController {
    @Resource
    private MqttPahoMessageHandler mqtt;

    @RequestMapping(value="/send")
    @ResponseBody
    public String sendMessage(){
        Message<String> message = MessageBuilder.withPayload("======44444444444444======").setHeader(MqttHeaders.TOPIC, "topicTest/teams/1").build();
        mqtt.handleMessage(message);
        System.out.println("成功");
        return "success";
    }
}

