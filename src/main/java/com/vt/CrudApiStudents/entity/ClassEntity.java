package com.vt.CrudApiStudents.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "class")
public class ClassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long classId;

    private String className;

    @OneToMany(mappedBy = "classEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<StudentEntity> students;


    public ClassEntity() {
    } 

    public ClassEntity(Long classId, String className, List<StudentEntity> students) {
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

    public List<StudentEntity> getStudents() {
        return students;
    }

    public void setStudents(List<StudentEntity> students) {
        this.students = students;
    }
    
    
}
