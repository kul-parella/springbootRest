package com.example.entity;

import java.util.Objects;

public class AccountDetails {


    private String custEcn;

    private String custCoNum;

    private String acctNum;

    private String acctCoNum;

    private String acctPrdCd;

    private String debitCardNumber;

    private String debitCardPrdctCd;

    private String merchantName;

    public AccountDetails() {
    }

    public String getCustEcn() {
        return custEcn;
    }

    public void setCustEcn(String custEcn) {
        this.custEcn = custEcn;
    }

    public String getCustCoNum() {
        return custCoNum;
    }

    public void setCustCoNum(String custCoNum) {
        this.custCoNum = custCoNum;
    }

    public String getAcctNum() {
        return acctNum;
    }

    public void setAcctNum(String acctNum) {
        this.acctNum = acctNum;
    }

    public String getAcctCoNum() {
        return acctCoNum;
    }

    public void setAcctCoNum(String acctCoNum) {
        this.acctCoNum = acctCoNum;
    }

    public String getAcctPrdCd() {
        return acctPrdCd;
    }

    public void setAcctPrdCd(String acctPrdCd) {
        this.acctPrdCd = acctPrdCd;
    }

    public String getDebitCardNumber() {
        return debitCardNumber;
    }

    public void setDebitCardNumber(String debitCardNumber) {
        this.debitCardNumber = debitCardNumber;
    }

    public String getDebitCardPrdctCd() {
        return debitCardPrdctCd;
    }

    public void setDebitCardPrdctCd(String debitCardPrdctCd) {
        this.debitCardPrdctCd = debitCardPrdctCd;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    @Override
    public String toString() {
        return "AccountDetails{" +
                "custEcn='" + custEcn + '\'' +
                ", custCoNum='" + custCoNum + '\'' +
                ", acctNum='" + acctNum + '\'' +
                ", acctCoNum='" + acctCoNum + '\'' +
                ", acctPrdCd='" + acctPrdCd + '\'' +
                ", debitCardNumber='" + debitCardNumber + '\'' +
                ", debitCardPrdctCd='" + debitCardPrdctCd + '\'' +
                ", merchantName='" + merchantName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountDetails that = (AccountDetails) o;
        return Objects.equals(custEcn, that.custEcn) &&
                Objects.equals(acctNum, that.acctNum) &&
                Objects.equals(acctCoNum, that.acctCoNum) &&
                Objects.equals(acctPrdCd, that.acctPrdCd) &&
                Objects.equals(debitCardNumber, that.debitCardNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(custEcn, acctNum, acctCoNum, acctPrdCd, debitCardNumber);
    }
}
