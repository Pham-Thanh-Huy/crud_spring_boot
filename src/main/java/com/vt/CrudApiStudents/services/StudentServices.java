package com.vt.CrudApiStudents.services;

import java.util.List;
import java.util.Optional;


import com.vt.CrudApiStudents.entity.ClassEntity;
import com.vt.CrudApiStudents.entity.SubjectEntity;
import com.vt.CrudApiStudents.repository.ClassRepository;
import com.vt.CrudApiStudents.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.vt.CrudApiStudents.dto.BaseResponse;
import com.vt.CrudApiStudents.dto.StudentDTO;
import com.vt.CrudApiStudents.entity.StudentEntity;
import com.vt.CrudApiStudents.repository.StudentRepository;

@Service
public class StudentServices {
    @Autowired
    private StudentRepository repository;

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private SubjectRepository subjectRepository;

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

    public BaseResponse<StudentEntity> addStudent(Long id, StudentDTO studentDTO) {
        BaseResponse<StudentEntity> response = new BaseResponse<>();
        ClassEntity classEntity = classRepository.findById(id).orElse(null);

        if (classEntity == null) {
            response.setMessage("Add Student Fail because Class Not Found");
            response.setCode(HttpStatus.NOT_FOUND.value());
            return response;
        }

        if (studentDTO.getName() == null || studentDTO.getName().isEmpty()) {
            response.setMessage("Name is required.");
            response.setCode(HttpStatus.BAD_REQUEST.value());
            return response;
        }

        if (studentDTO.getAge() <= 0) {
            response.setMessage("Age must be a positive value.");
            response.setCode(HttpStatus.BAD_REQUEST.value());
            return response;
        }


        String gender = studentDTO.getGender().toLowerCase();
        if (gender == null || (!gender.equalsIgnoreCase("male") && !gender.equalsIgnoreCase("female"))) {
            response.setMessage("Gender must be 'male' or 'female'");
            response.setCode(HttpStatus.BAD_REQUEST.value());
            return response;
        }


        StudentEntity student = new StudentEntity();
        student.setName(studentDTO.getName());
        student.setAge(studentDTO.getAge());
        student.setGender(gender);
        student.setAddress(studentDTO.getAddress());
        student.setClassEntity(classEntity);


        student = repository.save(student);

        response.setData(student);
        response.setMessage("Success");
        response.setCode(HttpStatus.OK.value());

        return response;
    }


    public BaseResponse<StudentEntity> updateStudent(Long id, StudentDTO studentDTO) {
        BaseResponse<StudentEntity> response = new BaseResponse<>();

        Optional<StudentEntity> studentEntityOptional = repository.findById(id);
        if (studentEntityOptional.isPresent()) {
            StudentEntity student = studentEntityOptional.get();

            if (studentDTO.getName() != null && !studentDTO.getName().isEmpty()) {
                student.setName(studentDTO.getName());
            }

            if (studentDTO.getAddress() != null) {
                student.setAddress(studentDTO.getAddress());
            }

            if (studentDTO.getGender() != null) {
                String gender = studentDTO.getGender().toLowerCase();
                if (!gender.equals("male") && !gender.equals("female")) {
                    response.setMessage("Invalid gender. Gender must be 'male' or 'female'");
                    response.setCode(HttpStatus.BAD_REQUEST.value());
                    return response;
                }
                student.setGender(gender);
            }


            Integer age = studentDTO.getAge();
            if (age == null) {
               student.setAge(student.getAge());
            }else{
                if (age < 0) {
                response.setMessage("Age must be a non-negative value.");
                response.setCode(HttpStatus.BAD_REQUEST.value());
                return response;
            }
                student.setAge(age);

            }

            // Lưu trạng thái cập nhật vào cơ sở dữ liệu
            student = repository.save(student);

            response.setData(student);
            response.setMessage("Success");
            response.setCode(HttpStatus.OK.value());
        } else {
            response.setMessage("Student not found");
            response.setCode(HttpStatus.NOT_FOUND.value());
        }

        return response;
    }


    public BaseResponse<StudentEntity> deleteStudent(Long id) {
        BaseResponse<StudentEntity> baseResponse = new BaseResponse<>();

        // Tìm dòng dữ liệu cần xóa
        StudentEntity StudentEntity = repository.findById(id).orElse(null);

        if (StudentEntity != null) {
            repository.deleteById(id);
            baseResponse.setData(StudentEntity);
            baseResponse.setMessage("Success");
            baseResponse.setCode(HttpStatus.OK.value());
        } else {
            baseResponse.setMessage("Student not found");
            baseResponse.setCode(HttpStatus.NOT_FOUND.value());
        }
        return baseResponse;
    }


    public BaseResponse<StudentEntity> registerSubjects(Long studentId, List<Long> subjectIds) {
        BaseResponse<StudentEntity> response = new BaseResponse<>();
        StudentEntity student = repository.findById(studentId).orElse(null);

        if (student == null) {
            response.setMessage("Student not found");
            response.setCode(HttpStatus.NOT_FOUND.value());
            return response;
        }

        List<SubjectEntity> selectedSubjects = subjectRepository.findAllById(subjectIds);

        if (selectedSubjects.size() != subjectIds.size()) {
            response.setMessage("One or more subjects do not exist.");
            response.setCode(HttpStatus.BAD_REQUEST.value());
            return response;
        }

        student.setSubjects(selectedSubjects);

        student = repository.save(student);

        response.setData(student);
        response.setMessage("Success");
        response.setCode(HttpStatus.OK.value());

        return response;
    }


}
