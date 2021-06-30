package com.example.dao;

import com.example.entity.AccountDetails;
import com.example.entity.GetAccountV1Request;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GetAccountDetailsV1DAOImpl implements GetAccountDetailsV1DAO {


    @Override
    public List<AccountDetails> getAccountDetails(GetAccountV1Request request) {

        AccountDetails acctDetails = new AccountDetails();
        acctDetails.setAcctCoNum("1234567890");
        acctDetails.setCustCoNum("1234567890");
        acctDetails.setAcctNum("8989098765678987");
        acctDetails.setAcctPrdCd("XCC");
        acctDetails.setCustEcn("12345");
        acctDetails.setDebitCardNumber("5050345678653456");
        acctDetails.setDebitCardPrdctCd("ACC");
        acctDetails.setMerchantName("Walmart");

        AccountDetails acctDetails1 = new AccountDetails();
        acctDetails1.setAcctCoNum("1234567890");
        acctDetails.setCustCoNum("1234567890");
        acctDetails1.setAcctNum("8989098765678987");
        acctDetails1.setAcctPrdCd("XCC");
        acctDetails1.setCustEcn("12345");
        acctDetails1.setDebitCardNumber("5050345678653456");
        acctDetails1.setDebitCardPrdctCd("ACC");
        acctDetails1.setMerchantName("Amazon");

        List<AccountDetails> accountDetailsList = new ArrayList<>();
        accountDetailsList.add(acctDetails);
        accountDetailsList.add(acctDetails1);

        return accountDetailsList;

    }
}
