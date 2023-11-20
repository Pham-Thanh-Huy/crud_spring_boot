package com.vt.CrudApiStudents.services;

import com.vt.CrudApiStudents.dto.SubjectDTO;
import com.vt.CrudApiStudents.dto.BaseResponse;

import com.vt.CrudApiStudents.entity.SubjectEntity;
import com.vt.CrudApiStudents.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServices {
    @Autowired
    private SubjectRepository repository;

    public List<SubjectEntity> getAll() {
        return repository.findAll();
    }

    public BaseResponse<SubjectEntity> getById(Long id) {
        BaseResponse<SubjectEntity> response = new BaseResponse<>();
        SubjectEntity subjectEntity = repository.findById(id).orElse(null);
        if (subjectEntity != null) {
            response.setData(subjectEntity);
            response.setMessage("Success");
            response.setCode(HttpStatus.OK.value());
        } else {
            response.setMessage("Subject not found");
            response.setCode(HttpStatus.NOT_FOUND.value());
        }
        return response;
    }

    public BaseResponse<SubjectEntity> addSubject(SubjectDTO subjectDTO) {
        BaseResponse<SubjectEntity> response = new BaseResponse<>();
        if (subjectDTO.getSubjectName() == null || subjectDTO.getSubjectName().isEmpty()) {
            response.setMessage("Subject name is required.");
            response.setCode(HttpStatus.BAD_REQUEST.value());
            return response;
        }

        if (subjectDTO.getSubjectCredits() <= 0) {
            response.setMessage("Subject credits must be a positive value.");
            response.setCode(HttpStatus.BAD_REQUEST.value());
            return response;
        }

        SubjectEntity subjectEntity = new SubjectEntity();
        subjectEntity.setSubjectName(subjectDTO.getSubjectName());
        subjectEntity.setSubjectCredits(subjectDTO.getSubjectCredits());

        SubjectEntity addedSubject = repository.save(subjectEntity);
        response.setData(addedSubject);
        response.setMessage("Success");
        response.setCode(HttpStatus.OK.value());
        return response;
    }

    public BaseResponse<SubjectEntity> updateSubject(Long id, SubjectDTO subjectDTO) {
        BaseResponse<SubjectEntity> response = new BaseResponse<>();
        Optional<SubjectEntity> existingSubjectOptional = repository.findById(id);
        if (existingSubjectOptional.isPresent()) {
            SubjectEntity existingSubject = existingSubjectOptional.get();

            if (subjectDTO.getSubjectName() != null && !subjectDTO.getSubjectName().isEmpty()) {
                existingSubject.setSubjectName(subjectDTO.getSubjectName());
            }

            if (subjectDTO.getSubjectCredits() > 0) {
                existingSubject.setSubjectCredits(subjectDTO.getSubjectCredits());
            } else {
                response.setMessage("Subject credits must be a positive value.");
                response.setCode(HttpStatus.BAD_REQUEST.value());
                return response;
            }

            existingSubject = repository.save(existingSubject);

            response.setData(existingSubject);
            response.setMessage("Success");
            response.setCode(HttpStatus.OK.value());
        } else {
            response.setMessage("Subject not found");
            response.setCode(HttpStatus.NOT_FOUND.value());
        }

        return response;
    }


    public BaseResponse<SubjectEntity> deleteSubject(Long id) {
        BaseResponse<SubjectEntity> baseResponse = new BaseResponse<>();

        // Tìm dòng dữ liệu cần xóa
        SubjectEntity StudentEntity = repository.findById(id).orElse(null);

        if (StudentEntity != null) {
            repository.deleteById(id);
            baseResponse.setData(StudentEntity);
            baseResponse.setMessage("Success");
            baseResponse.setCode(HttpStatus.OK.value());
        } else {
            baseResponse.setMessage("Subject not found");
            baseResponse.setCode(HttpStatus.NOT_FOUND.value());
        }
        return baseResponse;
    }
}
