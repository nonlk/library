package ru.courseProject.library.model.response;

import ru.courseProject.library.model.LibrError;
import ru.courseProject.library.model.enums.ErrorCode;

import java.io.Serializable;

public class BaseResponse<T> implements Serializable {
    protected LibrError error;
    protected T content;

    public LibrError getError() {
        return error;
    }

    public void setError(LibrError error) {
        this.error = error;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public BaseResponse<T> build(ErrorCode errorCode) {
        error = LibrError.get(errorCode);
        return this;
    }

    public BaseResponse<T> build(ErrorCode errorCode, String message) {
        error = LibrError.get(errorCode, message);
        return this;
    }

    public BaseResponse<T> build(LibrError src) {
        error = src;
        return this;
    }

    public BaseResponse<T> build(T content) {
        this.content = content;
        return this;
    }
}
