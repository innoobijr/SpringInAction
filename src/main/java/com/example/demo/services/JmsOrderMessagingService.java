/*
package com.example.demo.services;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;


import com.example.demo.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

@Service
public class JmsOrderMessagingService implements OrderMessagingService{

    private JmsTemplate jms;

    @Autowired
    public JmsOrderMessagingService(JmsTemplate jms){
        this.jms = jms;
    }

    @Override
    public void sendOrder(Order order){
        jms.convertAndSend("tacocloud.order.queue", order, this::addOrderSource);
    }
    /*  The equivalent with a lambda
    public void sendOrder(Order order){
        jms.send(session -> session.createObjectMessage(order));
    }


    private Message addOrderSource(Message message) throws JMSException {
        message.setStringProperty("X_ORDER_SORUCE", "WEB");
        return message;
    }
}*/