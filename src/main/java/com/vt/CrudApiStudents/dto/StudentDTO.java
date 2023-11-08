package com.vt.CrudApiStudents.dto;

import com.vt.CrudApiStudents.entity.ClassEntity;
import com.vt.CrudApiStudents.entity.SubjectEntity;
import lombok.Data;

import java.util.List;
@Data
public class StudentDTO {
    private String name;

    private int age;

    private String address;

    private String gender;

    private ClassEntity classDTO;

    private List<SubjectEntity> subjects;


}
