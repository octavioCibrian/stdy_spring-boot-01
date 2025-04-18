package com.restapi.stdy_spring_boot_01.controller;

import com.restapi.stdy_spring_boot_01.model.dto.LoginRequestDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

@RestController
public class LoginController {

    @Value("${spring.security.oauth2.client.registration.keycloak.client-id}")
    private String clientId;

    @Value("${spring.security.oauth2.client.registration.keycloak.client-secret}")
    private String clientSecret;

    @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
    private String baseUrl;

    @PostMapping("/login")
    public Mono<ResponseEntity<?>> login(@RequestBody LoginRequestDto loginRequestDto) {
        // URL for Keycloak token endpoint
        String tokenUrl = baseUrl + "/protocol/openid-connect/token";

        // Prepare the request body
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("client_id", clientId);
        requestBody.add("username", loginRequestDto.username());
        requestBody.add("password", loginRequestDto.password());
        requestBody.add("grant_type", "password");
        requestBody.add("client_secret", clientSecret);

        // Use RestTemplate to send the request
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(tokenUrl, requestBody, String.class);

        // Return the response from Keycloak
        return Mono.just(ResponseEntity.ok(response.getBody()));

    }

}
