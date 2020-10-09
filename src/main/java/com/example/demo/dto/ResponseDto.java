package com.example.demo.dto;

import java.util.List;

public class ResponseDto {
    private boolean success;
    private String message;
    private int httpStatus;
    private Object data;
    private List<String> details;

    public ResponseDto() {
    }

    public ResponseDto(boolean success, String message, int httpStatus, Object data, List<String> details) {
        this.success = success;
        this.message = message;
        this.httpStatus = httpStatus;
        this.data = data;
        this.details = details;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public List<String> getDetails() {
        return details;
    }

    public void setDetails(List<String> details) {
        this.details = details;
    }
}
