package com.austen;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class Client {
    private static int qos = 1;
    private static String broker = "tcp://localhost:1883";
    private static String userName = "admin";
    private static String passWord = "public";


    public static void main(String[] args) throws MqttException {

        MemoryPersistence persistence = new MemoryPersistence();
        MqttConnectOptions connOpts = new MqttConnectOptions();
        connOpts.setCleanSession(true);
        connOpts.setUserName(userName);
        connOpts.setPassword(passWord.toCharArray());
        connOpts.setConnectionTimeout(10);
        connOpts.setKeepAliveInterval(20);
//		String[] uris = {"tcp://10.100.124.206:1883","tcp://10.100.124.207:1883"};
//		connOpts.setServerURIs(uris);  //起到负载均衡和高可用的作用
        MqttClient mqttClient = new MqttClient(broker, "clientId1", persistence);
        mqttClient.connect(connOpts);
    }
}
