package com.leysoft.service.imple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leysoft.model.CustomMessage;
import com.leysoft.service.inter.SenderService;

@Service
public class SenderServiceImp implements SenderService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SenderServiceImp.class);
	
	@Autowired
	private KafkaTemplate<String, CustomMessage> kafkaTemplate;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Value(value = "${kafka.topic}")
	private String topic;
	
	@Override
	public void send(CustomMessage payload) throws JsonProcessingException {
		String info = mapper.writeValueAsString(payload);
		Message<CustomMessage> message = MessageBuilder.withPayload(payload)
				.setHeader(KafkaHeaders.TOPIC, topic)
				.setHeader("X-Custom-Header", "Set header").build();
		LOGGER.info("send: {}", info);
		kafkaTemplate.send(message);
	}
}
