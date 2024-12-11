package it.pkg.service.exception;

public class TokenException extends RuntimeException{
    public TokenException(String message, Throwable cause) {
        super(message, cause);
    }
}
