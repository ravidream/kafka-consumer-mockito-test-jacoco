package com.example.service;

import org.springframework.stereotype.Component;

@Component
public class MessageConsumerService {
    public boolean process(String message){
        return true;
    }
}
