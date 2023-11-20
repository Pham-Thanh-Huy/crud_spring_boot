package com.vt.CrudApiStudents.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vt.CrudApiStudents.dto.BaseResponse;
import com.vt.CrudApiStudents.dto.ClassDTO;
import com.vt.CrudApiStudents.entity.ClassEntity;
import com.vt.CrudApiStudents.services.ClassServices;

@RestController
@RequestMapping("api/class")
public class ClassController {

    @Autowired
    private ClassServices classServices;

    @GetMapping("/get/all")
    public List<ClassEntity> getAll() {
        return classServices.getAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<BaseResponse<ClassEntity>> getById(@PathVariable Long id) {
        BaseResponse<ClassEntity> baseResponse = classServices.getById(id);
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }

    @PostMapping("/add")
    public ResponseEntity<BaseResponse<ClassEntity>> addClass(@RequestBody ClassDTO classDTO) {
        BaseResponse<ClassEntity> baseResponse = classServices.addClass(classDTO);
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BaseResponse<ClassEntity>> updateClass(@PathVariable Long id,
            @RequestBody ClassDTO classEntity) {
        BaseResponse<ClassEntity> baseResponse = classServices.update(id, classEntity);
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }


    @GetMapping("/delete/{id}")
    public ResponseEntity<BaseResponse<ClassEntity>> deleteClass(@PathVariable Long id){
        BaseResponse<ClassEntity> baseResponse = classServices.deleteClass(id);
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }

}
