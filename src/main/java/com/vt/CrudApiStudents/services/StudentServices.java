package com.vt.CrudApiStudents.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vt.CrudApiStudents.entity.StudentEntity;
import com.vt.CrudApiStudents.reposistory.StudentReposistory;

@Service
public class StudentServices {
    @Autowired
    private StudentReposistory reposistory;

    public List<StudentEntity> getAll() {
        return reposistory.findAll();
    }

    public StudentEntity getById(Long id) {
        return reposistory.findById(id).orElse(null);
    }

    public StudentEntity addClass(StudentEntity studentEntity) {
        return reposistory.save(studentEntity);
    }

    public StudentEntity updateClass(StudentEntity studentEntity) {
        return reposistory.save(studentEntity);
    }

    public void deleteClass(Long id) {
        reposistory.deleteById(id);
    }
}
