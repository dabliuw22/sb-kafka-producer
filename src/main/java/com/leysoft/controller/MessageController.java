
package com.leysoft.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leysoft.dto.CustomMessageResponse;
import com.leysoft.model.CustomMessage;
import com.leysoft.service.inter.SenderService;

@RestController
@RequestMapping(
        value = {
            "/message"
        })
public class MessageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    private SenderService senderService;

    @GetMapping(
            value = {
                "/{message}"
            })
    public ResponseEntity<CustomMessageResponse> message(@PathVariable(
            name = "message") String message) {
        CustomMessageResponse response = new CustomMessageResponse();
        CustomMessage payload = new CustomMessage();
        try {
            payload.setMessage(message);
            senderService.send(payload);
            response.setMessage("processing message...");
        } catch (Exception e) {
            LOGGER.error("Error: {}", e.getMessage());
            response.setMessage("Error...");
        }
        return ResponseEntity.ok(response);
    }
}
