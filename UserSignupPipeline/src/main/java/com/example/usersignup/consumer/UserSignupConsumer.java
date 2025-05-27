package com.example.usersignup.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.avro.UserSignupEvent;

@Component
public class UserSignupConsumer {
	
	 @KafkaListener(topics = "user-signup", groupId = "user-signup-consumer")
	    public void consume(UserSignupEvent event) {
	        System.out.println("Consumed event: " + event);
	    }

}
