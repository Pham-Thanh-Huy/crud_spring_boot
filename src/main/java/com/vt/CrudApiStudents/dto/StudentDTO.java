package com.vt.CrudApiStudents.dto;



import java.util.List;

public class StudentDTO {
    private String name;

    private int age;

    private String address;

    private String gender;

    private ClassDTO classDTO;

    private List<SubjectDTO> subjects;

    public StudentDTO(String name, int age, String address, String gender, ClassDTO classDTO, List<SubjectDTO> subjects) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.gender = gender;
        this.classDTO = classDTO;
        this.subjects = subjects;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public ClassDTO getClassDTO() {
        return classDTO;
    }

    public void setClassDTO(ClassDTO classDTO) {
        this.classDTO = classDTO;
    }

    public List<SubjectDTO> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectDTO> subjects) {
        this.subjects = subjects;
    }
}
