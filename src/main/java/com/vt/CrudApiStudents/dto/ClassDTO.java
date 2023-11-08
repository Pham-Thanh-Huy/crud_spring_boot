package com.vt.CrudApiStudents.dto;

import com.vt.CrudApiStudents.entity.StudentEntity;
import lombok.Data;

import java.util.List;

@Data
public class ClassDTO {
    private Long classId;

    private String className;

    private List<StudentEntity> students;


}
