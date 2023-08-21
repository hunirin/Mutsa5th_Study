package com.example.api.dto;

import lombok.Data;

@Data
public class BeerPostDto {
    private String name;
    private Long cc;
    private Double alcohol;
}