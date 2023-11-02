package com.vt.CrudApiStudents.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ClassEntity getById(@PathVariable Long id) {
        return classServices.getById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addClass(@RequestBody ClassEntity classEntity) {
        Long classId = classEntity.getClassId();
        if (classId != null) {
            if (classServices.getById(classId) != null) {
                Map<String, String> response = new HashMap<>();
                response.put("message", "id Lớp đã tồn tại, không thể thêm");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        }
        classEntity.setClassId(0L);
        return ResponseEntity.ok(classServices.addClass(classEntity));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateClass(@PathVariable Long id, @RequestBody ClassEntity classEntity) {
        ClassEntity classUpdate = classServices.getById(id);
        if (classUpdate != null) {
            classUpdate.setClassName(classEntity.getClassName());
            classServices.updateClass(classUpdate);
            return ResponseEntity.ok(classUpdate);
        }
        Map<String, String> response = new HashMap<>();
        response.put("message", "Không tồn tại lớp với id là: " + id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    
    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteClass(@PathVariable Long id) {
        ClassEntity classDelete = classServices.getById(id);
        if (classDelete != null) {
            classServices.deleteClass(id);
            return ResponseEntity.ok(classDelete);
        }
        Map<String, String> response = new HashMap<>();
        response.put("message", "Không tồn tại lớp với id là: " + id + " để xóa");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
