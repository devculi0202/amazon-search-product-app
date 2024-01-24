package com.devculi.application.amazon.exceptions;

public class AbstractCustomException extends Exception {

  public AbstractCustomException(String message) {
    super(message);
  }
  public AbstractCustomException(Throwable throwable) {
    super(throwable);
  }
}
