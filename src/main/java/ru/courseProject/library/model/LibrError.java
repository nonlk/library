package ru.courseProject.library.model;

import ru.courseProject.library.model.enums.ErrorCode;

import java.io.Serializable;

public class LibrError implements Serializable {
    public static LibrError get() {
        return new LibrError();
    }

    public static LibrError get(ErrorCode errorCode) {
        return get(errorCode.getCode(), errorCode.getMessage());
    }

    public static LibrError get(ErrorCode errorCode, String message) {
        return get(errorCode.getCode(), message);
    }

    public static LibrError get(Long code, String message) {
        return new LibrError(code, message);
    }

    Long code;
    String message;

    public LibrError() {
        code = ErrorCode.OK.getCode();
    }

    public LibrError(Long code, String message) {
        this.code = code;
        this.message = message;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
