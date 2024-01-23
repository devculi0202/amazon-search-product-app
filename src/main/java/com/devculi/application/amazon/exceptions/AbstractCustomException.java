package com.devculi.application.amazon.exceptions;

public class AbstractCustomException extends Exception {
  protected  Throwable throwable;
  protected String message;

  public AbstractCustomException(String message) {
    super(message);
    this.message = message;
  }

  public AbstractCustomException(Throwable throwable) {
    super(throwable);
    this.throwable = throwable;
  }



  protected getMessage ()

}
