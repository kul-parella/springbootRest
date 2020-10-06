package com.example.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Get Account Details V1 Request.
 * @author Kuladeep Parella.
 */

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
        "customerKey",
        "accountList"
})
public class GetAccountV1Request {


    @JsonProperty("customerKey")
    @Valid
    @NotNull
    private CustomerKey customerKey;


    @JsonProperty("accountList")
    @JsonPropertyDescription("Account List.")
    @Size(min=1)
    @Valid
    @NotNull
    private List<AccountInfo> accountList = new ArrayList<>();

    public GetAccountV1Request() {
    }


    public GetAccountV1Request(CustomerKey customerKey, List<AccountInfo> accountList) {
        super();
        this.customerKey = customerKey;
        this.accountList = accountList;
    }

    @JsonProperty("customerKey")
    public CustomerKey getCustomerKey() {
        return customerKey;
    }

    @JsonProperty("customerKey")
    public void setCustomerKey(CustomerKey customerKey) {
        this.customerKey = customerKey;
    }

    @JsonProperty("accountList")
    public List<AccountInfo> getAccountList() {
        return accountList;
    }

    @JsonProperty("accountList")
    public void setAccountList(List<AccountInfo> accountList) {
        this.accountList = accountList;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(GetAccountV1Request.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
                .append('[');
        sb.append("customerKey");
        sb.append('=');
        sb.append(((this.customerKey==null)?"<null>":this.customerKey));
        sb.append(',');
        sb.append("accountList");
        sb.append('=');
        sb.append(((this.accountList==null)?"<Null>":this.accountList));
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
        result = ((result*31)+ ((this.customerKey==null)?0:this.customerKey.hashCode()));
        result = ((result*31)+ ((this.accountList == null)?0:this.accountList.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if(other == this) {
            return true;
        }
        if(other instanceof GetAccountV1Request == false) {
            return false;
        }
        GetAccountV1Request rhs = ((GetAccountV1Request) other);
        return(((this.customerKey==rhs.customerKey)||((this.customerKey!=null)&&this.customerKey.equals(rhs.customerKey)))
                &&((this.accountList == rhs.accountList)|| ((this.accountList!=null)&& this.accountList.equals(rhs.accountList))));
    }


}
