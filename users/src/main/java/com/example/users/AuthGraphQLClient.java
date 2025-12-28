package com.example.users;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

@Service
public class AuthGraphQLClient {
    @Value("${auth.service.url:http://localhost:8082/graphql}")
    private String authServiceUrl;

    public TokenResponse getToken(String username) {
        RestTemplate restTemplate = new RestTemplate();
        String query = "query($username: String!) { getToken(username: $username) { token } }";
        Map<String, Object> variables = new HashMap<>();
        variables.put("username", username);
        Map<String, Object> request = new HashMap<>();
        request.put("query", query);
        request.put("variables", variables);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(request, headers);
        Map response = restTemplate.postForObject(authServiceUrl, entity, Map.class);
        Map data = (Map) response.get("data");
        Map tokenResp = (Map) data.get("getToken");
        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setToken((String) tokenResp.get("token"));
        return tokenResponse;
    }
}
