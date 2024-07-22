package com.garuda.notification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/ping")
public class PingController {

    @GetMapping
    public String ping() {
        return "Success!";
    }
}

//curl -X POST -H "Content-Type: application/json" -d "{\"name\":\"Wick\"}" http://localhost:8082/api/v1/notification