package com.example.services;

import com.example.dao.GetAccountDetailsV1DAO;
import com.example.entity.AccountDetails;
import com.example.entity.GetAccountV1Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAccountDetailsV1ServiceImpl implements GetAccountDetailsV1Service{

    @Autowired
    private GetAccountDetailsV1DAO dao;

    @Override
    public ResponseEntity getAccountDetails(GetAccountV1Request request) {
        List<AccountDetails> accountDetailsList = dao.getAccountDetails(request);
        return new ResponseEntity(accountDetailsList, HttpStatus.OK);
    }
}
