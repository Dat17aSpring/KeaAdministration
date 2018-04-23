package dk.kea.controller;


import dk.kea.model.Student;
import dk.kea.repository.IStudentRepository;
import dk.kea.repository.StudentArrayListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentsController {

    // Dependency injection
    // Strategy pattern

    @Autowired
    private IStudentRepository studentsRepository;


    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("student_data", studentsRepository.readAll());
        return "index";
    }

    @GetMapping("/create")
    public String create(){
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Student student){
        studentsRepository.create(student);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id, Model model){
        Student stud = studentsRepository.read(id);
        model.addAttribute("student", stud );
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("id") Integer id){
        studentsRepository.delete(id);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String update(@RequestParam("id") int id, Model model){
        model.addAttribute("student", studentsRepository.read(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute Student student){
        studentsRepository.update(student);
        return "redirect:/";
    }








}
