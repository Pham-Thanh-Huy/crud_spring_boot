package com.vt.CrudApiStudents.dto;



import com.vt.CrudApiStudents.entity.StudentEntity;
import lombok.Data;

import java.util.List;

@Data
public class SubjectDTO {
    private String subjectName;

    private int subjectCredits;
    private List<StudentEntity> students;


}
