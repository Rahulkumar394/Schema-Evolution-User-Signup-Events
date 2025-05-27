package com.example.usersignup.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.avro.UserSignupEvent;

@Service
public class UserSignupProducer {
	
	 private final KafkaTemplate<String, UserSignupEvent> kafkaTemplate;
	 
	 // Constructor-based dependency injection
	 public UserSignupProducer(KafkaTemplate<String, UserSignupEvent> kafkaTemplate) {
	      this.kafkaTemplate = kafkaTemplate;
	 }

	 public void sendSignupEvent(UserSignupEvent event) {
	      kafkaTemplate.send("user-signup", event);
	 }

}
