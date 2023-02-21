package com.example.demo.repository;

import com.example.demo.model.jpa.Student;
import com.example.demo.model.sql.QStudent;
import com.example.demo.model.sql.TbStudent;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import static com.example.demo.model.jpa.QStudent.student;

@Repository
public class StudentRepositoryWithJpa {
    @Autowired
    private JPAQueryFactory queryFactory;

    public List<Student> findAll() {
        return queryFactory.selectFrom(student).fetch();
    }


}
