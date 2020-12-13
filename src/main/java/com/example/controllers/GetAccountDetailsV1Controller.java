package com.example.controllers;

import com.example.entity.GetAccountDetailsV1Response;
import com.example.entity.GetAccountV1Request;
import com.example.services.GetAccountDetailsV1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class GetAccountDetailsV1Controller {

    private GetAccountDetailsV1Service service;

    @Autowired
    public GetAccountDetailsV1Controller(GetAccountDetailsV1Service service){
        this.service = service;
    }



    @PostMapping(value = "/api/getAccountDetails")
    public ResponseEntity<GetAccountDetailsV1Response> getAccountDetails(
            @Valid @RequestBody final GetAccountV1Request request,
            @RequestHeader final HttpHeaders headers
            ){
            return service.getAccountDetails(request);

    }





}
