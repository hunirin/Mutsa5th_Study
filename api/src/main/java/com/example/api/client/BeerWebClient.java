package com.example.api.client;

import com.example.api.dto.BeerGetDto;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class BeerWebClient {
    public BeerGetDto getBeer() {
        WebClient webClient = WebClient.builder().build();
        String url = "https://random-data-api.com/api/v2/beers";

        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(BeerGetDto.class)
                .block();
    }
}
