package com.adv_investor.auth_module.controllers.heath;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/check")
public class HeathCheckController {
    @GetMapping("/health")
    public String healthCheck() {
        return "OK";
    }
}
