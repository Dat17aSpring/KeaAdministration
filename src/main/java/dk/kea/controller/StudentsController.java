package dk.kea.controller;


import dk.kea.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentsController {

    private List<Student> students;

    public StudentsController(){
        students = new ArrayList<>();
        students.add(new Student(1, "Claus", "Bove", LocalDate.now(), "21212121-2121"));
        students.add(new Student(2, "Anna", "Bove", LocalDate.now(), "fsdfdsfsdf"));
        students.add(new Student(3, "Ib", "Bove", LocalDate.now(), "257657567"));

    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("student_data", students);
        return "index";
    }

    @GetMapping("/create")
    public String create(){
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Student student){
        students.add(student);
        return "redirect:/";
    }

}
