package com.example.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class rabitMqController {

    @Value("${spring.application.name}")
    String sang;

    @RequestMapping("/sang")
    public String sang() {
        return this.sang;
    }

}
