package com.vt.CrudApiStudents.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.vt.CrudApiStudents.dto.BaseResponse;
import com.vt.CrudApiStudents.dto.ClassDTO;

import com.vt.CrudApiStudents.entity.ClassEntity;
import com.vt.CrudApiStudents.reposistory.ClassReposistory;

@Service
public class ClassServices {

    @Autowired
    private ClassReposistory reposistory;

    public List<ClassEntity> getAll() {
        return reposistory.findAll();
    }

    public ClassEntity getById(Long id) {
        return reposistory.findById(id).orElse(null);
    }

    public BaseResponse<ClassEntity> addClass(ClassDTO classDTO) {
        BaseResponse<ClassEntity> response = new BaseResponse<>();
        try {
            if (classDTO.getClassName() != null && !classDTO.getClassName().isEmpty()) {
                ClassEntity classEntity = new ClassEntity();
                classEntity.setClassName(classDTO.getClassName());
                classEntity = reposistory.save(classEntity);    
                response.setData(classEntity);
                response.setCode(200);
                response.setMessage("success");
            }else{
                response.setMessage("Ivalid input");
                response.setCode(400);
            }

        } catch (Exception e) {
            response.setMessage(e.getMessage());
            response.setCode(500);
        }
        return response;
    }

    public ClassEntity updateClass(ClassEntity classEntity) {
        return reposistory.save(classEntity);
    }

    public BaseResponse<ClassEntity> update(Long id, ClassDTO input) {
        BaseResponse<ClassEntity> response = new BaseResponse<>();

        try {
            Optional<ClassEntity> classEntityOptional = reposistory.findById(id);

            if (classEntityOptional.isPresent()) {
                ClassEntity classEntity = classEntityOptional.get();
                if (input.getClassName() != null && !input.getClassName().isEmpty()) {
                    classEntity.setClassName(input.getClassName());
                    classEntity = reposistory.save(classEntity);

                    response.setData(classEntity);
                    response.setMessage("Success");
                    response.setCode(200);
                } else {
                    response.setMessage("Invalid input");
                    response.setCode(400);
                }
            } else {
                response.setMessage("Not found");
                response.setCode(404);
            }

        } catch (Exception e) {
            response.setMessage(e.getMessage());
            response.setCode(500);
        }

        return response;
    }

    public void deleteClass(Long id) {
        reposistory.deleteById(id);
    }

}
