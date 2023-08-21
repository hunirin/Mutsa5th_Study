package com.example.api.service;

import com.example.api.client.BeerRestClient;
import com.example.api.dto.BeerGetDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BeerService {
    private final BeerRestClient client;

    public BeerService(BeerRestClient client) {
        this.client = client;
    }

    public void drinkBeer() {
        log.info("order beer");
        // TODO API 를 활용해 맥주 정보 받아오기
        BeerGetDto beer = client.getBeer();
        // 핵심은 맥주 정보
        // 맥주 정보를 받아오는 방법은 비즈니스 로직에서 벗어났다 할 수 있지 않을까?
        log.info("맛있다!");
    }
}