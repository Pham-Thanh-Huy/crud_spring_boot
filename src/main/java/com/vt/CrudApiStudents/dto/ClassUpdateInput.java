package com.vt.CrudApiStudents.dto;



public class ClassUpdateInput {
    private Long classId;

    private String className;


    public ClassUpdateInput(Long classId, String className) {
        this.classId = classId;
        this.className = className;
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

    
}
