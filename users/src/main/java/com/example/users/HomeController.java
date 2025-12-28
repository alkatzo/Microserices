package com.example.users;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/")
    public String home() {
        logger.info("Received request for /, redirecting to auth service login.");
        // Redirect to auth service login endpoint
        return "redirect:http://localhost:8082/oauth2/authorization/okta";
    }
}
