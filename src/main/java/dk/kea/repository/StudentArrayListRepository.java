package dk.kea.repository;

import dk.kea.model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentArrayListRepository implements IStudentRepository {

    private List<Student> students;

    public StudentArrayListRepository(){
        students = new ArrayList<>();
        students.add(new Student(1, "Claus", "Bove", LocalDate.now(), "21212121-2121"));
        students.add(new Student(2, "Anna", "Bove", LocalDate.now(), "fsdfdsfsdf"));
        students.add(new Student(3, "Ib", "Bove", LocalDate.now(), "257657567"));
    }

    @Override
    public List<Student> readAll() {
        return students;
    }

    @Override
    public void create(Student student) {
        student.setStudentId(students.size()+1);
        students.add(student);
    }

    @Override
    public Student read(int id) {
        return null;
    }

    @Override
    public void update(Student student) {

    }

    @Override
    public void delete(int id) {

    }
}
