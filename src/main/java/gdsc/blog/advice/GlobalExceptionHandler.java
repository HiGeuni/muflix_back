package gdsc.blog.advice;

import gdsc.blog.dto.Error.ErrorResponse;
import gdsc.blog.exception.AlreadyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({NoSuchElementException.class})
    protected ResponseEntity<ErrorResponse> noSuchElementExceptionHandler(NoSuchElementException e){
        ErrorResponse errorResponse = ErrorResponse.builder()
                .code("Item Not Found")
                .message(e.getMessage())
                .build();

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({AlreadyExistException.class})
    protected ResponseEntity<ErrorResponse> aleadyExistExceptionHandler(AlreadyExistException e){
        ErrorResponse errorResponse = ErrorResponse.builder()
                .code("The Field Already Exists")
                .message(e.getMessage())
                .build();

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
