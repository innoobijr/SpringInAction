package com.example.demo.services;

import com.example.demo.model.Order;

public interface OrderMessagingService {

    void sendOrder(Order order);

}