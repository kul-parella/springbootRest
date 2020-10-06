package com.example.dao;

import com.example.entity.AccountDetails;
import com.example.entity.GetAccountV1Request;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
public interface GetAccountDetailsV1DAO {


List<AccountDetails> getAccountDetails(GetAccountV1Request request) ;


}
