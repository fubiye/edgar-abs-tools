package com.fubiye.edgar.tools.exception;

public class DocParseException extends RuntimeException {
  public DocParseException() {
    super();
  }

  public DocParseException(String message) {
    super(message);
  }

  public DocParseException(String message, Throwable cause) {
    super(message, cause);
  }

  public DocParseException(Throwable cause) {
    super(cause);
  }

  protected DocParseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
