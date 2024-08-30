package com.br.nunes.sports.exception;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class HandlerException {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ExceptionDetails> handleEntityNotFoundException(EntityNotFoundException entityNotFound) {
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .message(entityNotFound.getMessage())
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.NOT_FOUND.value())
                        .title("EntityNotFoundException , Check the Documentation")
                        .details(entityNotFound.getCause() != null ? entityNotFound.getCause().toString() : "No details available")
                        .developerMessage(entityNotFound.getClass().getName())
                        .build(), HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<ExceptionDetails> handleEntityExistsException(EntityExistsException entityExist) {
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .message(entityExist.getMessage())
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.CONFLICT.value())
                        .title("EntityExistsException , Check the Documentation")
                        .details(entityExist.getCause() != null ? entityExist.getCause().toString() : "No details available")
                        .developerMessage(entityExist.getClass().getName())
                        .build(), HttpStatus.CONFLICT);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionDetails> handleMethodArgumentNotValidException(MethodArgumentNotValidException methodArg) {
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .message("Error, invalid Argument")
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .title("MethodArgumentNotValidException")
                        .details(methodArg.getBindingResult().getFieldErrors().toString())
                        .developerMessage(methodArg.getClass().getName())
                        .build(), HttpStatus.BAD_REQUEST);
    }


}