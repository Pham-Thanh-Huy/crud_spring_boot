package com.vt.CrudApiStudents.reposistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vt.CrudApiStudents.entity.StudentEntity;

@Repository
public interface StudentReposistory extends JpaRepository<StudentEntity, Long> {
    
}
