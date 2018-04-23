package dk.kea.repository;

import dk.kea.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class StudentsReadFromFileRepository implements IStudentRepository{
    @Override
    public List<Student> readAll() {
        return null;
    }

    @Override
    public void create(Student student) {

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
