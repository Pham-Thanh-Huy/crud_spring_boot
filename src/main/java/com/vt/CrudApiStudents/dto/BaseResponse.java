package com.vt.CrudApiStudents.dto;

public class BaseResponse<T> {
    private T data;
    private String message;
    private Integer code;
}
