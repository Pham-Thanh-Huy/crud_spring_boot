package com.vt.CrudApiStudents.dto;


public class BaseResponse<T> {
    private T data;
    private String message; // success, 
    private Integer code; // 200, 400, 500

    
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }

    
}
