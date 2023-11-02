package com.vt.CrudApiStudents.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vt.CrudApiStudents.entity.ClassEntity;
import com.vt.CrudApiStudents.reposistory.ClassReposistory;

@Service
public class ClassServices {

    @Autowired
    private ClassReposistory reposistory;

    public List<ClassEntity> getAll(){
        return reposistory.findAll();
    }

    public ClassEntity getById(Long id){
        return reposistory.findById(id).orElse(null);
    }
    

    public ClassEntity addClass(ClassEntity classEntity){
        return reposistory.save(classEntity);
    }

    public ClassEntity updateClass(ClassEntity classEntity){
        return reposistory.save(classEntity);
    }


    public void deleteClass(Long id){
        reposistory.deleteById(id);
    }

    

}
