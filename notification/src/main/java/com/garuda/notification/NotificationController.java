package com.garuda.notification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

record NotificationRequest(String name) { }

record NotificationResponse(Boolean triggered) { }

@Slf4j
@RestController
@RequestMapping("/notification")
public class NotificationController {

    @PostMapping
    public ResponseEntity<NotificationResponse> trigger(@RequestBody NotificationRequest request) {
        log.debug("Notification triggered for {}", request.name());
        return new ResponseEntity<>(new NotificationResponse(true), HttpStatus.OK);
    }
}

//curl -X POST -H "Content-Type: application/json" -d "{\"name\":\"Wick\"}" http://localhost:8082/api/v1/notification