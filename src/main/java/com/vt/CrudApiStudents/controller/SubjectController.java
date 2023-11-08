package com.vt.CrudApiStudents.controller;

import com.vt.CrudApiStudents.dto.BaseResponse;
import com.vt.CrudApiStudents.dto.SubjectDTO;
import com.vt.CrudApiStudents.entity.SubjectEntity;
import com.vt.CrudApiStudents.services.SubjectServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subject/")
public class SubjectController {
    @Autowired
    private SubjectServices subjectServices;

    @GetMapping("/get/all")
    public List<SubjectEntity> getAll() {
        return subjectServices.getAll();
    }

    @GetMapping("get/{id}")
    public ResponseEntity<BaseResponse<SubjectEntity>> getSubjectById(@PathVariable Long id) {
        BaseResponse<SubjectEntity> baseResponse = subjectServices.getById(id);
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }

    @PostMapping("add")
    public ResponseEntity<BaseResponse<SubjectEntity>> addSubject(@RequestBody SubjectDTO subjectDTO) {
        BaseResponse<SubjectEntity> baseResponse = subjectServices.addSubject(subjectDTO);
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<BaseResponse<SubjectEntity>> updateSubject(@PathVariable Long id, @RequestBody SubjectDTO subjectDTO) {
        BaseResponse<SubjectEntity> baseResponse = subjectServices.updateSubject(id, subjectDTO);
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }

    @GetMapping("delete/{id}")
    public ResponseEntity<BaseResponse<SubjectEntity>> deleteSubject(@PathVariable Long id) {
        BaseResponse<SubjectEntity> baseResponse = subjectServices.deleteSubject(id);
        return new ResponseEntity<>(baseResponse, HttpStatus.valueOf(baseResponse.getCode()));
    }
}
