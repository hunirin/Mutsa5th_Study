package com.example.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BeerClientServiceTests {
    @Autowired
    private BeerClientService service;

    @Test
    public void getBeerTest(){
        service.getBeer();
    }

    @Test
    public void postBeerTest() {
        service.postBeer();
    }
}
