package com.khamid.ebookproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handleBadRequestException(BadRequestException e) {
        var error = new ErrorResponse(e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResouceNotFound.class)
    public ResponseEntity<ErrorResponse> handlerResourceNotFound(ResouceNotFound e) {
        var error = new ErrorResponse(e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateExeption.class)
    public ResponseEntity<ErrorResponse> handlerDuplicateExeption(DuplicateExeption e) {
        var error = new ErrorResponse(e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }
}
