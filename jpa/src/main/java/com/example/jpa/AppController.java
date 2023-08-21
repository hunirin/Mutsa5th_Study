package com.example.jpa;


import com.example.jpa.dto.StudentDto;
import com.example.jpa.entities.StudentEntity;
import org.hibernate.sql.exec.spi.StandardEntityInstanceResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppController {
    // 사용자의 입력을 받는 요소
    private final AppService service;

    public AppController(AppService service) {
        this.service = service;
    }

    @GetMapping("create")
    public @ResponseBody String create() {
        this.service.createStudent(
                "alex",
                35,
                "010-1234-5678",
                "alex@gamil.com"
        );
        return "done";
    }

    @GetMapping("read")
    public @ResponseBody String readOne() {
        this.service.readStudent(1L);
        return "done-read-one";
    }

    @GetMapping("read-all")
    public @ResponseBody List<StudentDto> readAll() {
        this.service.readStudentAll();
//        return "done-read-all";
        return this.service.readStudentAll();
    }

    @GetMapping("update")
    public @ResponseBody String update() {
        this.service.updateStudent(1L, "alexander");
        return "done-update";
    }

    @GetMapping("delete")
    public @ResponseBody String delete() {
        this.service.deleteStudent(1L);
        return "done-delete";
    }

    @GetMapping("find")
    public @ResponseBody String find() {
        this.service.findAllByTest();
        return "done-fine";
    }





//    // RequestMapping과 같이 사용
//    @RequestMapping("students")
//    public void students() {
//        List<Object> result = service.readStudentAll();
//    }
//
//    @GetMapping("home")
//    public String home() {
//        return "home"; // 돌려줄 html을 못찾음
//    }
//
//    @GetMapping("body")
//    public String body() {
//        return "body";
//    }
}
