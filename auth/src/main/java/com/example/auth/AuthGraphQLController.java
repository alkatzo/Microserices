package com.example.auth;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class AuthGraphQLController {
    @QueryMapping
    public TokenResponse getToken(@Argument String username) {
        // Fake token generation
        String token = "token_for_" + username;
        return new TokenResponse(token);
    }
}
