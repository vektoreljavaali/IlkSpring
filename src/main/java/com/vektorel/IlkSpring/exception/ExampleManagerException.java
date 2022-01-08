package com.vektorel.IlkSpring.exception;


import lombok.Getter;

@Getter
public class ExampleManagerException extends RuntimeException {

    private final ErrorType errorType;

    public ExampleManagerException(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public ExampleManagerException(ErrorType errorType, String customMessage) {
        super(customMessage);
        this.errorType = errorType;
    }
}