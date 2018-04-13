package dk.kea.controller;


import dk.kea.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentsController {

    private List<Student> students;

    public StudentsController(){
        students = new ArrayList<>();
    }

    @GetMapping("/")
    public String index(Model model){

       System.out.println(students.get(0));
        model.addAttribute("student_data", students);
        return "index";
    }

    @GetMapping("/create")
    public String create(){
        students.add(new Student(1, "Claus", "Bove", LocalDate.now(), "21212121-2121"));
        return "create";
    }

}
