package com.example.controllers;

import com.example.entity.GetAccountDetailsV1Response;
import com.example.utils.Constants;
import com.example.utils.GetAccountDetailsUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
public class ControllerRestExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        StringBuilder builder = new StringBuilder().append(ex.getMethod())
                .append( " Method is not Supported for this request. Supported Methods are " );
        ex.getSupportedHttpMethods().forEach(httpMethod -> builder.append(httpMethod).append(Constants.SPACE));
        GetAccountDetailsV1Response response = new GetAccountDetailsV1Response();
        response.setStatusMessages(GetAccountDetailsUtils.createStatusMessageList(Constants.CODE_METHOD_NOT_ALLOWED, builder.toString()));
        return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.METHOD_NOT_ALLOWED);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        StringBuilder builder = new StringBuilder("Message Not Readable, Reason : [ ");
        if(ex.getCause() != null) {
            builder.append(ex.getCause().getLocalizedMessage());
        }else {
            builder.append(ex.getLocalizedMessage());
        }
        builder.append(" ]");

        GetAccountDetailsV1Response response = new GetAccountDetailsV1Response();
        response.setStatusMessages(GetAccountDetailsUtils
                .createStatusMessageList(Constants.CODE_MESSAGE_NOT_READABLE, GetAccountDetailsUtils
                        .trimRemainingLines(builder.toString())));
        return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleAllException(Exception ex) {
        GetAccountDetailsV1Response response = new GetAccountDetailsV1Response();
        String exMsg = new StringBuilder().append("Exception occured while processing ... : ")
                .append(ex.getMessage().toString()).toString();
        response.setSystemErrors(GetAccountDetailsUtils.processExceptionSystemErrors(exMsg));
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(DataNotFoundException.class)
    protected ResponseEntity<Object> handleDataNotFoundException(DataNotFoundException ex) {
        String statMsg = new StringBuilder().append(Constants.NOT_FOUND_ERR_MSG).toString();
        GetAccountDetailsV1Response response = new GetAccountDetailsV1Response();
        response.setStatusMessages(GetAccountDetailsUtils.createStatusMessageList(Constants.DATA_NOT_FOUND,
                GetAccountDetailsUtils.trimRemainingLines(statMsg)));
        return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }


}
