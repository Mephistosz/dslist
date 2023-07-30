package com.intensivao.dslist.controller.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.intensivao.dslist.services.exception.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<StandardError> resourceNotFoundException(ResourceNotFoundException e,
      HttpServletRequest request) {
    HttpStatus status = HttpStatus.NOT_FOUND;

    StandardError err = new StandardError(LocalDateTime.now(), status.value(), "Object not found", e.getMessage(),
        request.getRequestURI());

    return ResponseEntity.status(status).body(err);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ArgumentErrors> handleInvalidArgument(MethodArgumentNotValidException ex,
      HttpServletRequest request) {

    HttpStatus status = HttpStatus.BAD_REQUEST;

    Map<String, String> mapError = new HashMap<>();

    ex.getBindingResult().getFieldErrors().forEach(error -> mapError.put(error.getField(), error.getDefaultMessage()));

    ArgumentErrors err = new ArgumentErrors(LocalDateTime.now(), status.value(), mapError,
        request.getRequestURI());

    return ResponseEntity.status(status).body(err);
  }

  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
  public ResponseEntity<ArgumentErrors> handleTypeMismatch(MethodArgumentTypeMismatchException ex,
      HttpServletRequest request) {

    HttpStatus status = HttpStatus.BAD_REQUEST;

    Map<String, String> mapError = new HashMap<>();

    mapError.put(ex.getName(), "Invalid value. Expected " + ex.getRequiredType().getSimpleName());

    ArgumentErrors err = new ArgumentErrors(LocalDateTime.now(), status.value(), mapError,
        request.getRequestURI());

    return ResponseEntity.status(status).body(err);
  }

}
