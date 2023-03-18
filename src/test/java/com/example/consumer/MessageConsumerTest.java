package com.example.consumer;

import com.example.service.MessageConsumerService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MessageConsumerTest {

    @Mock
    MessageConsumerService messageConsumerService;
    @InjectMocks
    MessageConsumer messageConsumer;

    @Test
    void listenerTest(){
        ConsumerRecord<String, String> record = new ConsumerRecord<>("topic", 0, 123L, "key", "value");
        messageConsumer.listener(record);
        verify(messageConsumerService, times(1)).process(anyString());

    }
}
