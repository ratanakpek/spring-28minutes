package ratanak.pek.restful.response;

import jdk.nashorn.internal.runtime.ECMAException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ratanak.pek.restful.controller.UserNotFoundExceiption;

import java.util.Date;

/**
 * Created by r.pek on 12/22/2017.
 */
@ControllerAdvice
@RestController
public class CustomizeResponseHanlder
        extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceiptions(Exception ex, WebRequest request) {
        ExceptionResponse response =
                new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<Object>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundExceiption.class)
    public final ResponseEntity<Object> handleUserNotFoundExceiptions(UserNotFoundExceiption ex, WebRequest request) {
        ExceptionResponse response =
                new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<Object>(response, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object>
    handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                 HttpHeaders headers, HttpStatus status, WebRequest request) {

        ExceptionResponse response =
                new ExceptionResponse(new Date(), "Validaton failed!" , ex.getBindingResult().toString());

        return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
    }

}
