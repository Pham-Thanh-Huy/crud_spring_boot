package com.vt.CrudApiStudents.dto;



import java.util.List;

public class SubjectDTO {
    private String subjectName;

    private int subjectCredits;
    private List<StudentDTO> students;

    public SubjectDTO(String subjectName, int subjectCredits, List<StudentDTO> students) {
        this.subjectName = subjectName;
        this.subjectCredits = subjectCredits;
        this.students = students;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getSubjectCredits() {
        return subjectCredits;
    }

    public void setSubjectCredits(int subjectCredits) {
        this.subjectCredits = subjectCredits;
    }

    public List<StudentDTO> getStudents() {
        return students;
    }

    public void setStudents(List<StudentDTO> students) {
        this.students = students;
    }
}
