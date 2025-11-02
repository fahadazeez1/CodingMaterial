package com.example.revision_4.Error;

import jdk.management.jfr.RemoteRecordingStream;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ErrorHandleUtil {

    @ExceptionHandler(UsernameNotFoundException.class)
    ResponseEntity<ErrorHandleEx> HandleUserNameNotFoundException(UsernameNotFoundException ex){
        ErrorHandleEx error = new ErrorHandleEx( LocalDateTime.now(),HttpStatus.NOT_FOUND, "Sorry Username is not availble in the Record !"+ex.getMessage());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(BadCredentialsException.class)
    ResponseEntity<ErrorHandleEx> badcred(Exception ex){
        ErrorHandleEx error =  new ErrorHandleEx(LocalDateTime.now(), HttpStatus.NOT_FOUND,"Not Availbale");
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }



    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    ResponseEntity<ErrorHandleEx> Alltype(Exception ex){
        ErrorHandleEx error = new ErrorHandleEx(LocalDateTime.now() , HttpStatus.CONFLICT, "Wrong Request Type");
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }


}




