package com.vt.CrudApiStudents.dto;

import java.util.List;

public class ClassDTO {
    private Long classId;

    private String className;

    private List<StudentDTO> students;

    public ClassDTO(Long classId, String className, List<StudentDTO> students) {
        this.classId = classId;
        this.className = className;
        this.students = students;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<StudentDTO> getStudents() {
        return students;
    }

    public void setStudents(List<StudentDTO> students) {
        this.students = students;
    }
}
