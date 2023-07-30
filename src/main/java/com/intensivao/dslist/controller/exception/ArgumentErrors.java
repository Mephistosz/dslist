package com.intensivao.dslist.controller.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ArgumentErrors {
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
  private LocalDateTime timestamp;
  private Integer status;
  private Map<String, String> errors = new HashMap<>();
  private String path;

  public ArgumentErrors() {
  }

  public ArgumentErrors(LocalDateTime timestamp, Integer status, Map<String, String> errors, String path) {
    this.timestamp = timestamp;
    this.status = status;
    this.errors = errors;
    this.path = path;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(LocalDateTime timestamp) {
    this.timestamp = timestamp;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Map<String, String> geterrors() {
    return errors;
  }

  public void seterrors(Map<String, String> errors) {
    this.errors = errors;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

}
