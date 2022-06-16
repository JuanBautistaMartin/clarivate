package com.clarivate.test.config;

import com.clarivate.test.exceptions.ExceptionError;
import com.clarivate.test.exceptions.TextNotEmptyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
class ControllerAdvice {

  @ExceptionHandler(TextNotEmptyException.class)
  protected ResponseEntity<ExceptionError> handleTextNotEmptyException(TextNotEmptyException ex) {
    return buildResponseEntity(
      ExceptionError.builder()
        .status(HttpStatus.NOT_FOUND.toString())
        .message(ex.getMessage())
        .build());
  }

  private ResponseEntity<ExceptionError> buildResponseEntity(ExceptionError error) {
    return new ResponseEntity<ExceptionError>(error, HttpStatus.BAD_REQUEST);
  }
}
