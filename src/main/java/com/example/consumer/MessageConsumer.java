package com.example.consumer;

import com.example.service.MessageConsumerService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MessageConsumer {

	@Autowired
	MessageConsumerService messageConsumerService;
	@KafkaListener(topics = "test", groupId = "test-group")
	public void listener(ConsumerRecord<String, String> consumerRecord) {
	    System.out.println("Received Message : "+ consumerRecord.value() + consumerRecord.headers());
		messageConsumerService.process(consumerRecord.value());
	}
}

