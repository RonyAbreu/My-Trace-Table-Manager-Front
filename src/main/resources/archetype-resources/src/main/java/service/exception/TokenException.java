#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.exception;

public class TokenException extends RuntimeException{
    public TokenException(String message, Throwable cause) {
        super(message, cause);
    }
}
