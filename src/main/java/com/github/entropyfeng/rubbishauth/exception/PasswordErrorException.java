package com.github.entropyfeng.rubbishauth.exception;

/**
 * @author entropyfeng
 * @date 2019/6/19 20:39
 */
public class PasswordErrorException extends Exception {
  
    public PasswordErrorException() {
        super();
    }

   
    public PasswordErrorException(String message) {
        super(message);
    }

  
    public PasswordErrorException(String message, Throwable cause) {
        super(message, cause);
    }


    public PasswordErrorException(Throwable cause) {
        super(cause);
    }


    protected PasswordErrorException(String message, Throwable cause,
                        boolean enableSuppression,
                        boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
