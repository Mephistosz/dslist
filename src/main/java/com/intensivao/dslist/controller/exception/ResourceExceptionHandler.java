package com.intensivao.dslist.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.intensivao.dslist.services.exception.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<StandardError> resourceNotFoundException(ResourceNotFoundException e,
      HttpServletRequest request) {
    HttpStatus status = HttpStatus.NOT_FOUND;

    StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Object not found",
        e.getMessage(), e.getMessage(), request.getRequestURI());

    return ResponseEntity.status(status).body(err);
  }

}
