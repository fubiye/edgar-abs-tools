package com.fubiye.edgar.tools.exception;

public class DocReadException extends RuntimeException {
  public DocReadException() {
    super();
  }

  public DocReadException(String message) {
    super(message);
  }

  public DocReadException(String message, Throwable cause) {
    super(message, cause);
  }

  public DocReadException(Throwable cause) {
    super(cause);
  }

  protected DocReadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}