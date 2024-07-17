/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.plazoleta.demo.infraestructure.rest;

/**
 *
 * @author usuario
 */
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class WebClientClient {
    private final WebClient webClient;

    public WebClientClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://localhost:8082").build();
    }

    public Mono<Boolean> fetchDataFromApi(String endpoint) {
        endpoint = "/api/v1/users/owner/1";
        return this.webClient.get()
                .uri(endpoint)
                .retrieve()
                .bodyToMono(Boolean.class);
    }
}