package com.example.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class UsersGraphQLController {
    @Autowired
    private AuthGraphQLClient authGraphQLClient;

    @QueryMapping
    public TokenResponse requestToken(@Argument String username) {
        return authGraphQLClient.getToken(username);
    }
}
