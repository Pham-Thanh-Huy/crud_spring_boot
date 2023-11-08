package com.vt.CrudApiStudents.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "Subject")
public class SubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long subjectId;

    private String subjectName;

    private int subjectCredits;

    @ManyToMany(mappedBy = "subjects")
    @JsonIgnore
    private List<StudentEntity> students;


}
