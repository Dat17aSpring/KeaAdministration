package dk.kea.repository;

import dk.kea.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentsDbRepository implements IStudentRepository {


    @Autowired
    JdbcTemplate jdbc;
    SqlRowSet sqlRowSet;

    @Override
    public List<Student> readAll() {

        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM KeaStudentsDb.students";
        sqlRowSet = jdbc.queryForRowSet(sql);

        while (sqlRowSet.next()) {

            students.add(new Student(sqlRowSet.getInt("students_id"),
                    sqlRowSet.getString("first_name"),
                    sqlRowSet.getString("last_name"),
                    sqlRowSet.getDate("enrollment_date").toLocalDate(),
                    sqlRowSet.getString("cpr"))
            );
        }
        return students;
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
