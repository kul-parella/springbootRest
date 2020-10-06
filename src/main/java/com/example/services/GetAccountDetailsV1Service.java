package com.example.services;

import com.example.entity.GetAccountV1Request;
import org.springframework.http.ResponseEntity;

public interface GetAccountDetailsV1Service {

    public ResponseEntity getAccountDetails(GetAccountV1Request request);

}
