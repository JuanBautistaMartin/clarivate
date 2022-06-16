package com.clarivate.test.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class TextNotEmptyException extends RuntimeException {

  public TextNotEmptyException(String message) {
    super(message);
  }

}
