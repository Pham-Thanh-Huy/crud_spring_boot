package com.vt.CrudApiStudents.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.vt.CrudApiStudents.dto.BaseResponse;
import com.vt.CrudApiStudents.dto.StudentDTO;
import com.vt.CrudApiStudents.entity.StudentEntity;
import com.vt.CrudApiStudents.reposistory.StudentReposistory;

@Service
public class StudentServices {
    @Autowired
    private StudentReposistory repository;

    public List<StudentEntity> getAll() {
        return repository.findAll();
    }

    public BaseResponse<StudentEntity> getById(Long id) {
        BaseResponse<StudentEntity> response = new BaseResponse<>();
        StudentEntity studentEntity = repository.findById(id).orElse(null);
        if (studentEntity != null) {
            response.setData(studentEntity);
            response.setMessage("Success");
            response.setCode(HttpStatus.OK.value());
        } else {
            response.setMessage("Student not found");
            response.setCode(HttpStatus.NOT_FOUND.value());
        }
        return response;
    }

    // public BaseResponse<StudentEntity> addClass(StudentDTO studentDTO) {
        
    // }

    public StudentEntity updateClass(StudentEntity studentEntity) {
        return repository.save(studentEntity);
    }

    public void deleteClass(Long id) {
        repository.deleteById(id);
    }
}
