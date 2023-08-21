package com.example.mybatis.model;

import lombok.Data;

//@Getter
//@Setter
//@RequiredArgsConstructor
//@ToString
//@EqualsAndHashCode
@Data // 위 다섯개를 합친 어노테이션
public class Student {
    private Long id; // long 대신 Long 한 이유: null값을 넣을수있음
    private String name;
    private Integer age; // int 대신 Integer 한 이유: null값을 넣을수있음
    private String phone;
    private String email;
}
