package com.jp.calculadora_saque_aniversario_fgts.web.exception;

import com.jp.calculadora_saque_aniversario_fgts.infra.exception.BusinessException;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ProblemDetail handleException(HttpServletRequest httpRequest, Exception ex){
        log.error("Unhandled exception: {}", ex.getMessage());
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(INTERNAL_SERVER_ERROR, ex.getMessage());
        problemDetail.setInstance(URI.create(httpRequest.getRequestURI()));
        return problemDetail;
    }

    @ExceptionHandler(BusinessException.class)
    public ProblemDetail handleBusinessException(HttpServletRequest httpServletRequest, BusinessException ex){
        log.error("Business rule exception: {}", ex.getMessage());
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(BAD_REQUEST, ex.getMessage());
        problemDetail.setInstance(URI.create(httpServletRequest.getRequestURI()));
        return problemDetail;
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ProblemDetail handleDataIntegrityViolationException(HttpServletRequest httpRequest, DataIntegrityViolationException ex) {
        log.error("Violation of a rule that compromises the database");
        ProblemDetail problemDetail = ProblemDetail
                .forStatusAndDetail(BAD_REQUEST, "Data integrity violation: " + ex.getMostSpecificCause().getMessage());
        problemDetail.setInstance(URI.create(httpRequest.getRequestURI()));
        return problemDetail;
    }

}
