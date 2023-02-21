package com.example.demo.web;

import com.example.demo.dto.Dto;
import com.example.demo.model.jpa.Student;
import com.example.demo.model.sql.TbStudent;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/students")
    public List<TbStudent> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/stu")
    public TbStudent findById() {
        return studentService.findById();
    }

//    @PostMapping("/students")
//    public void saveStudent() {
//         studentService.save();
//    }

    @DeleteMapping("/students")
    public Long delete() {
        return studentService.delete();
    }

    @PutMapping("/students")
    public Long update() {
        return studentService.update();

    }

//@PostMapping(value = "/stud")
//    public String insert(@RequestParam("id")String id, @RequestParam("firstname") String firstname
//        ,@RequestParam("lastname")String lastname, @RequestParam("stuAge")String stuAge){
//    studentService.insertStudentWithJpa();
//     return "hello"+ firstname+","+lastname+","+stuAge ;
//}


    //Dto Dynamic insert
    @PostMapping("/students")
    public String insertJpa(@RequestBody Dto studentInsertDto) {
        studentService.insertJpa(studentInsertDto);
        return "insert" + studentInsertDto;
    }
}
