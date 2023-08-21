package com.example.jpa.entities;

/* CREATE TABLE students (
*   id INTEGER PRIMARY KEY AUTOINCREMENT,
*   name TEXT,
*   age INTEGER,
*   phone TEXT,
*   email TEXT)
 */

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "students")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Column 어노테이션에 인자를 전달해서 테이블 ConStraint 추가 가능
//    @Column(name = "username", nullable = false)
    private String name;
    private Integer age;
//    @Column(unique = true)
    private String phone;
    private String email;
}
