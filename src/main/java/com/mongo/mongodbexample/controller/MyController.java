package com.mongo.mongodbexample.controller;

import com.mongo.mongodbexample.models.Student;
import com.mongo.mongodbexample.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/student")
public class MyController {
@Autowired
    private StudentRepository studentRepository;
    @PostMapping("/")
    public ResponseEntity<?> addStudent(@RequestBody Student student)
    {
        Student save = studentRepository.save(student);
         return ResponseEntity.ok(save);
    }

    @GetMapping("/get")
    public ResponseEntity<?> getStudents()
    {
        return ResponseEntity.ok(studentRepository.findAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getStudent(@PathVariable("id") Integer id) {
        Optional<Student> byId = studentRepository.findById(id);
        if (byId.isPresent()) {
            return new ResponseEntity<Student>(byId.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No stdent found with id:" + id, HttpStatus.NOT_FOUND);
        }

//        @DeleteMapping("/delete/{id}")
//        public ResponseEntity<Object> deleteStudentById(@PathVariable("id") Integer id) {
//            Optional<Student> data = studentRepository.findById(id);
//            if (data.isPresent()) {
//                studentRepository.deleteById(id);
//                return new ResponseEntity<>("Student deleted with id: " + id, HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>("No student found with id: " + id, HttpStatus.NOT_FOUND);
//            }
      }

      @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStudent(@RequestBody Student student,@PathVariable("id") Integer id) {

          Optional<Student> data = studentRepository.findById(id);
          if (data.isPresent()) {
              Student studentdb = data.get();
              studentdb.setName(student.getName());
              studentdb.setCity(student.getCity());
              studentdb.setCollege(student.getCollege());
              studentRepository.save(studentdb);
              return new ResponseEntity<>(studentdb, HttpStatus.OK);
          } else {
              return new ResponseEntity<>("No student found with id: " + id, HttpStatus.NOT_FOUND);
          }

      }
}
