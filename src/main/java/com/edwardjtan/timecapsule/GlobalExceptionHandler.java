package com.edwardjtan.timecapsule;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

record ErrorResponse(String error, String message, LocalDateTime timestamp) {}

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * catch all unprocessed errors
     * @param ex the actual Error
     * @return a formatted error responese object that converted to json
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponse handleGenericException(Exception ex) {
        System.err.println("an unexpected error occured: " + ex.getMessage());
        ex.printStackTrace();

        return new ErrorResponse(
            "Internal Server Error",
            "An unexpected error on the server, please try again later",
            LocalDateTime.now()
        );
    }
}
