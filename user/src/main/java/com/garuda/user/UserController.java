package com.garuda.user;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


record NotificationRequest(String name) { }

record NotificationResponse(Boolean triggered) { }

record CreateUserRequest (String name) {}

record User (String name, boolean notificationTriggered) {}


@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Value("${garuda.notification-url}")
    private String notificationUrl;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping
    public ResponseEntity<User> create(@RequestBody CreateUserRequest request) {

        log.info("Incoming request for: {}", request.name());
        // call notification
        NotificationResponse result = restTemplate.postForObject(
                notificationUrl,
                new NotificationRequest(request.name()), NotificationResponse.class);

        assert result != null;

        User response = new User(request.name(), result.triggered());

        log.info("Process Complete");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}


//curl -X POST -H "Content-Type: application/json" -d "{\"name\":\"Wick\"}" http://localhost:8081/api/v1/user
