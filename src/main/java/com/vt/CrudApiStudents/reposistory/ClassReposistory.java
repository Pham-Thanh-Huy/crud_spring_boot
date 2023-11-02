package com.vt.CrudApiStudents.reposistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vt.CrudApiStudents.entity.ClassEntity;

@Repository
public interface ClassReposistory extends JpaRepository<ClassEntity, Long> {
    
}
