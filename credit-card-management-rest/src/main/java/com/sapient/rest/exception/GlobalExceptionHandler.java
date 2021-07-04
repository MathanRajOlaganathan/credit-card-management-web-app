package com.sapient.rest.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mathan Raj O
 * @version 1.0
 * @since 03/07/2021
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiCallError<String>> handleNotFoundException(HttpServletRequest httpServletRequest, NotFoundException exception) {
        log.error("NotFoundException - {} - {}", httpServletRequest.getRequestURI(), exception.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ApiCallError<>("Not Found Exception", List.of(exception.getMessage())));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiCallError<String>> handleInternalServerError(HttpServletRequest request, MethodArgumentNotValidException ex) {
        log.error("ConstraintViolationException {}\n", request.getRequestURI(), ex.toString());

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ApiCallError<>("Constraint Violation Exception",
                        ex.getBindingResult().
                                getAllErrors().stream()
                                .map(error -> error.getDefaultMessage()).collect(Collectors.toList()

                        )));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiCallError<String>> handleInternalServerError(HttpServletRequest request, Exception ex) {
        log.error("handleInternalServerError {}\n", request.getRequestURI(), ex.toString());

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiCallError<>("Internal server error", List.of(ex.getMessage())));
    }

    @Getter
    @AllArgsConstructor
    private static class ApiCallError<T> {
        private final String message;
        private final List<T> details;
    }
}
