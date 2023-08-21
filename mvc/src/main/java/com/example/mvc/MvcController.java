package com.example.mvc;

import com.example.mvc.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Controller
public class MvcController {

    private LottoService lottoService;

//    private int hitCount = 0;

    public MvcController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    @RequestMapping("/hits")
    public String hits(Model model) {
//        hitCount++;
        int hitCount = lottoService.addHit();
        model.addAttribute("hits", hitCount);
        return "hits";
    }

    @RequestMapping("/lotto")
    public String lotto(Model model) {
        List<Integer> winningNums = lottoService.nextWinningNumber();

        model.addAttribute("winningNums", winningNums);

        return "lotto";
    }

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Hello, Thymeleaf!");
        return "home";
    }

    @RequestMapping("/student")
    public String student(Model model) {
        model.addAttribute("object",
                new Student("panghun lee", "hun053@naver.com"));
        return "student";
    }

    @RequestMapping("/is-logged-in")
    public String isLoggedIn(Model model) {
        model.addAttribute("isLoggedIn", false);
        return "if-unless";
    }

    @RequestMapping("/each")
    public String items(Model model) {
        List<String> listOfStrings = new ArrayList<>();
        listOfStrings.add("foo");
        listOfStrings.add("bar");
        listOfStrings.add("baz");

        model.addAttribute("listOfStrings", listOfStrings);
//        for (String item : listOfStrings);

        List<Student> studentList = Arrays.asList(
                new Student("Alex", "alex@gmail.com"),
                new Student("bred", "bred@gmail.com"),
                new Student("chad", "chad@gmail.com")
        );
        model.addAttribute("studentList",studentList);

        return "each";
    }
}
