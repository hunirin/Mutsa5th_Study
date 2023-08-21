package com.example.lombok;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class StudentDto { // DTO는 일반적으로 데이터를 담기 위한 객체
    private Long id;
    private String name;
    private String email;


}
