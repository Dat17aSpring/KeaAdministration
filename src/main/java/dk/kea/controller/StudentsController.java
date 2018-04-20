package dk.kea.controller;


import dk.kea.model.Student;
import dk.kea.repository.StudentArrayListRepository;
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


    private StudentArrayListRepository studentsRepository;

    private List<Student> students;

    public StudentsController(){

        studentsRepository = new StudentArrayListRepository();

       students = new ArrayList<>();
       /* students.add(new Student(1, "Claus", "Bove", LocalDate.now(), "21212121-2121"));
        students.add(new Student(2, "Anna", "Bove", LocalDate.now(), "fsdfdsfsdf"));
        students.add(new Student(3, "Ib", "Bove", LocalDate.now(), "257657567"));
*/
    }

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

        //student.setStudentId(students.size()+1);
        //students.add(student);

        studentsRepository.create(student);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id, Model model){

        Student stud = students.get(id-1);
        model.addAttribute("student", stud );
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("id") Integer id){
        students.remove(id-1);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String update(@RequestParam("id") int id, Model model){
        Student stud = students.get(id-1);
        model.addAttribute("student", stud );
        return "edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute Student student){
        students.remove(student.getStudentId() -1);
        students.add(student);
        return "redirect:/";
    }








}
