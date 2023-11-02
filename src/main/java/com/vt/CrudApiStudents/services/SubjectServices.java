package com.vt.CrudApiStudents.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vt.CrudApiStudents.entity.SubjectEntity;
import com.vt.CrudApiStudents.reposistory.SubjectReposistory;

@Service
public class SubjectServices {
    @Autowired
    private SubjectReposistory reposistory;

    public List<SubjectEntity> getAll() {
        return reposistory.findAll();
    }

    public SubjectEntity getById(Long id) {
        return reposistory.findById(id).orElse(null);
    }

    public SubjectEntity addClass(SubjectEntity subjectEntity) {
        return reposistory.save(subjectEntity);
    }

    public SubjectEntity updateClass(SubjectEntity subjectEntity) {
        return reposistory.save(subjectEntity);
    }

    public void deleteClass(Long id) {
        reposistory.deleteById(id);
    }
}
