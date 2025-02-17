#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.controller.exception;

import ${package}.service.exception.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class ErroExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroResponse> validationErro(MethodArgumentNotValidException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ValidationErro validationErro = new ValidationErro(Instant.now(), status.value(), "Validation erro", request.getRequestURI());
        for (FieldError error: e.getFieldErrors()){
            validationErro.addErro(error.getField(), error.getDefaultMessage());
        }
        return ResponseEntity.status(status).body(validationErro);
    }

    @ExceptionHandler(InvalidUserException.class)
    public ResponseEntity<ErroResponse> invalidUserErro(InvalidUserException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErroResponse erroResponse = new ErroResponse(Instant.now(),status.value(),"Usuário não existe, inválido",request.getRequestURI());
        return ResponseEntity.status(status).body(erroResponse);
    }

    @ExceptionHandler(UserNotHavePermissionException.class)
    public ResponseEntity<ErroResponse> userNotHavePermissionErro(UserNotHavePermissionException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.FORBIDDEN;
        ErroResponse erroResponse = new ErroResponse(Instant.now(),status.value(),e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(erroResponse);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ErroResponse> userAlreadyExistsErro(UserAlreadyExistsException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErroResponse erroResponse = new ErroResponse(Instant.now(),status.value(),e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(erroResponse);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErroResponse> userNotFoundErro(UserNotFoundException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErroResponse erroResponse = new ErroResponse(Instant.now(),status.value(),e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(erroResponse);
    }
}
