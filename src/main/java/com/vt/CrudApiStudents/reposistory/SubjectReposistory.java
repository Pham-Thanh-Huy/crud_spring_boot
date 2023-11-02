package com.vt.CrudApiStudents.reposistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vt.CrudApiStudents.entity.SubjectEntity;

@Repository
public interface SubjectReposistory extends JpaRepository<SubjectEntity, Long> {
    
}
