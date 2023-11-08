package com.vt.CrudApiStudents.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.vt.CrudApiStudents.dto.BaseResponse;
import com.vt.CrudApiStudents.dto.ClassDTO;
import com.vt.CrudApiStudents.entity.ClassEntity;
import com.vt.CrudApiStudents.repository.ClassRepository;

@Service
public class ClassServices {

    @Autowired
    private ClassRepository repository;

    public List<ClassEntity> getAll() {
        return repository.findAll();
    }

    public BaseResponse<ClassEntity> getById(Long id) {
        BaseResponse<ClassEntity> response = new BaseResponse<>();
        ClassEntity classEntity = repository.findById(id).orElse(null);
        if (classEntity != null) {
            response.setData(classEntity);
            response.setMessage("Success");
            response.setCode(HttpStatus.OK.value());
        } else {
            response.setMessage("Class not found");
            response.setCode(HttpStatus.NOT_FOUND.value());
        }

        return response;
    }

    public BaseResponse<ClassEntity> addClass(ClassDTO classDTO) {
        BaseResponse<ClassEntity> response = new BaseResponse<>();
        if (classDTO.getClassName() != null && !classDTO.getClassName().isEmpty()) {
            ClassEntity classEntity = new ClassEntity();
            classEntity.setClassName(classDTO.getClassName());
            classEntity = repository.save(classEntity);
            response.setData(classEntity);
            response.setCode(HttpStatus.OK.value());
            response.setMessage("success");
        } else {
            response.setMessage("Ivalid input");
            response.setCode(HttpStatus.NOT_FOUND.value());
        }
        return response;
    }

    public ClassEntity updateClass(ClassEntity classEntity) {
        return repository.save(classEntity);
    }

    public BaseResponse<ClassEntity> update(Long id, ClassDTO input) {
        BaseResponse<ClassEntity> response = new BaseResponse<>();

        Optional<ClassEntity> classEntityOptional = repository.findById(id);

        if (classEntityOptional.isPresent()) {
            ClassEntity classEntity = classEntityOptional.get();
            if (input.getClassName() != null && !input.getClassName().isEmpty()) {
                classEntity.setClassName(input.getClassName());
                classEntity = repository.save(classEntity);

                response.setData(classEntity);
                response.setMessage("Success");
                response.setCode(HttpStatus.OK.value());
            } else {
                response.setMessage("Invalid input");
                response.setCode(HttpStatus.BAD_REQUEST.value());
            }
        } else {
            response.setMessage("Not found");
            response.setCode(HttpStatus.NOT_FOUND.value());
        }
        return response;
    }

    public BaseResponse<ClassEntity> deleteClass(Long id) {
        BaseResponse<ClassEntity> baseResponse = new BaseResponse<>();

        // Tìm dòng dữ liệu cần xóa
        ClassEntity classEntity = repository.findById(id).orElse(null);

        if (classEntity != null) {
            repository.deleteById(id);
            baseResponse.setData(classEntity);
            baseResponse.setMessage("Success");
            baseResponse.setCode(HttpStatus.OK.value());

        } else {
            baseResponse.setMessage("Class not found");
            baseResponse.setCode(HttpStatus.NOT_FOUND.value());
        }
        return baseResponse;
    }

}
