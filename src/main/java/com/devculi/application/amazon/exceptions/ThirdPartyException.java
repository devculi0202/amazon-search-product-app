package com.devculi.application.amazon.exceptions;

public class ThirdPartyException extends  AbstractCustomException{
  public ThirdPartyException(String message) {
    super(message);
  }

  public ThirdPartyException(Throwable throwable) {
    super(throwable);
  }
}
