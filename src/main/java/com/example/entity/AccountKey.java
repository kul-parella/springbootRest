package com.example.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


/**
 * AccountKey entity class.
 * @author Kuladeep Parella.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
        "accountNumber",
        "companyNumber",
        "hoganProductCode"
})
public class AccountKey {

    @JsonProperty("accountNumber")
    @JsonPropertyDescription("Account Number.")
    @Pattern(regexp = "[A-Z0-9\\-\\s]{1,23}")
    @NotNull
    private String accountNumber;

    @JsonProperty("companyNumber")
    @JsonPropertyDescription("Company Number")
    @Pattern(regexp = "\\d{3,5}$")
    @NotNull
    private String companyNumber;

    @JsonProperty("productCode")
    @JsonPropertyDescription("Product code")
    @Pattern(regexp = "[0-9A-Z]{3}$")
    @NotNull
    private String productCode;

    public AccountKey() {
    }

    public AccountKey(String accountNumber, String companyNumber, String productCode) {
        super();
        this.accountNumber = accountNumber;
        this.companyNumber = companyNumber;
        this.productCode = productCode;
    }

    @JsonProperty("accountNumber")
    public String getAccountNumber() {
        return accountNumber;
    }

    @JsonProperty("accountNumber")
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @JsonProperty("companyNumber")
    public String getCompanyNumber() {
        return companyNumber;
    }

    @JsonProperty("companyNumber")
    public void setCompanyNumber(String companyNumber) {
        this.companyNumber = companyNumber;
    }

    @JsonProperty("productCode")
    public String getProductCode() {
        return productCode;
    }

    @JsonProperty("productCode")
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(AccountKey.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
                .append('[');
        sb.append("accountNumber");
        sb.append('=');
        sb.append(((this.accountNumber==null)?"<null>":this.accountNumber));
        sb.append(',');
        sb.append("companyNumber");
        sb.append('=');
        sb.append(((this.companyNumber==null)?"<Null>":this.companyNumber));
        sb.append(',');
        sb.append("productCode");
        sb.append('=');
        sb.append(((this.productCode==null)?"<null>":this.productCode));
        sb.append(',');
        if(sb.charAt((sb.length()-1)) == ',') {
            sb.setCharAt((sb.length()-1), ']');
        }else {
            sb.append(']');
        }

        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result*31)+ ((this.accountNumber==null)?0:this.accountNumber.hashCode()));
        result = ((result*31)+ ((this.companyNumber == null)?0:this.companyNumber.hashCode()));
        result = ((result*31)+ ((this.productCode == null)?0:this.productCode.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if(other == this) {
            return true;
        }
        if(other instanceof AccountKey == false) {
            return false;
        }
        AccountKey rhs = ((AccountKey) other);
        return(((this.accountNumber==rhs.accountNumber)||((this.accountNumber!=null)&&this.accountNumber.equals(rhs.accountNumber)))
                &&((this.companyNumber == rhs.companyNumber)|| ((this.companyNumber!=null)&& this.companyNumber.equals(rhs.companyNumber)))
                &&((this.productCode == rhs.productCode)|| ((this.productCode!=null)&& this.productCode.equals(rhs.productCode))));


    }


}
