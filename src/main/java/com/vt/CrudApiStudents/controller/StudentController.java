package com.vt.CrudApiStudents.controller;

import com.vt.CrudApiStudents.dto.BaseResponse;
import com.vt.CrudApiStudents.dto.StudentDTO;

import com.vt.CrudApiStudents.entity.StudentEntity;
import com.vt.CrudApiStudents.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student/")
public class StudentController {
    @Autowired
    private StudentServices studentServices;


    @GetMapping("/get/all")
    public List<StudentEntity> getAll() {
        return studentServices.getAll();
    }

    @GetMapping("get/{id}")
    public ResponseEntity<BaseResponse<StudentEntity>> getStudentById(@PathVariable Long id){
        BaseResponse<StudentEntity> baseResponse = studentServices.getById(id);
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }

    @PostMapping("add/{id}")
    public ResponseEntity<BaseResponse<StudentEntity>> addStudent(@PathVariable Long id,  @RequestBody  StudentDTO studentDTO){
        BaseResponse<StudentEntity> baseResponse = studentServices.addStudent(id, studentDTO);
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<BaseResponse<StudentEntity>> updateStudent(@PathVariable Long id,  @RequestBody  StudentDTO studentDTO){
        BaseResponse<StudentEntity> baseResponse = studentServices.updateStudent(id, studentDTO);
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }

    @GetMapping("delete/{id}")
    public ResponseEntity<BaseResponse<StudentEntity>> deleteStudent(@PathVariable Long id){
        BaseResponse<StudentEntity> baseResponse = studentServices.deleteStudent(id);
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }

    @PostMapping("register/{studentId}")
    public ResponseEntity<BaseResponse<StudentEntity>> registerSubjects(
            @PathVariable Long studentId,
            @RequestBody List<Long> subjectIds
    ) {
        BaseResponse<StudentEntity> baseResponse = studentServices.registerSubjects(studentId, subjectIds);
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }
}
