package edu.java.controller.exception;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExeceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExeceptionHandler.class);

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleBusinessExeception(IllegalArgumentException businessExeception) {
        return new ResponseEntity<String>(businessExeception.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNotFoundException(NoSuchElementException notFoundExeception) {
        return new ResponseEntity<String>("Resource ID not Found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handleUnexpectedException(Throwable unExpectedExeception) {

        logger.error("Unexpected server error, see the logs", unExpectedExeception);
        return new ResponseEntity<String>("Unexpected server error, see the logs", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
