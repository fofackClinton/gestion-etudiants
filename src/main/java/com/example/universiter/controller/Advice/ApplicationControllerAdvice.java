package com.example.universiter.controller.Advice;

import com.example.universiter.Dto.ErrorEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CONFLICT;

@ControllerAdvice
public class ApplicationControllerAdvice {
    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler({EntityNotFoundException.class})
    public @ResponseBody ErrorEntity handeException(EntityNotFoundException e) {
        return new ErrorEntity(null, e.getMessage());
    }
//exemple de la gestion d'une erreue de conflic
   // @ResponseStatus(CONFLICT)
    //@ExceptionHandler({EntityNotFoundException.class})
    //public @ResponseBody ErrorEntity handleRuntimeException(EntityNotFoundException e) {
      //  return new ErrorEntity(null, e.getMessage());
    //}

}
