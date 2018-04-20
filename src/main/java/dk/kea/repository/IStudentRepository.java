package dk.kea.repository;

import dk.kea.model.Student;
import java.util.List;

public interface IStudentRepository {
    // Interface = kontrakt som andre
    // klasser kan love at de opfylder

    // CRUD + readAll
   List<Student> readAll();
   void create(Student student);
   Student read(int id);
   void update(Student student);
   void delete(int id);

}
