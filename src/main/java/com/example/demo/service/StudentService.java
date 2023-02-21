package com.example.demo.service;

import com.example.demo.dto.Dto;
import com.example.demo.model.jpa.Student;
import com.example.demo.model.sql.TbStudent;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.StudentRepositoryWithJpa;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@AllArgsConstructor
@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentRepository studentRepositoryWithJpa;

    @Transactional
    public List<TbStudent> getAllStudents() {
        var students = studentRepository.findAll();
        students.forEach(tbStudent -> System.out.println(tbStudent.getFirstname()));
        return students;
    }

    @Transactional
    public TbStudent findById() {
        return studentRepository.findById();
    }

//    @Transactional
//    public Long save() {
//        return studentRepository.insert();
//    }

    @Transactional
    public Long delete() {
        return studentRepository.delete();
    }

    @Transactional
    public Long update() {
        return studentRepository.update();
    }

//    @PersistenceContext
//    private EntityManager entityManager;
//    @Transactional
//    public TbStudent insertWithQuery(String id, String firstname, String lastname, String stuAge) {
//                  TbStudent student=new TbStudent();
//                student.setId( student.getId());
//               student .setFirstname(student.getFirstname());
//               student .setLastname(student.getLastname());
//                student.setStuAge(student.getStuAge());
//               return studentRepositoryWithJpa.insert(student);
//    }

    //Dto
    @Transactional
    public TbStudent insertJpa(Dto studentInsertDto) {
        TbStudent student = new TbStudent();
        student.setId(studentInsertDto.getId());
        student.setFirstname(studentInsertDto.getFirstName());
        student.setLastname(studentInsertDto.getLastName());
        student.setStuAge(studentInsertDto.getStuAge());
        return studentRepositoryWithJpa.insert(student);
    }

}
