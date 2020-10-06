package com.example.entity;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
        "cutomerNumber",
        "companyNumber"
})
public class CustomerKey {

    @JsonProperty("customerNumber")
    @JsonPropertyDescription("Customer Number")
    @Pattern(regexp = "^\\d{1,15}$")
    @NotNull
    private String customerNumber;

    @JsonProperty("companyNumber")
    @JsonPropertyDescription("company Number")
    @Pattern(regexp = "\\d{3,5}$")
    @NotNull
    private String companyNumber;

    public CustomerKey() {
    }

    public CustomerKey( String customerNumber, String companyNumber) {
        this.customerNumber = customerNumber;
        this.companyNumber = companyNumber;
    }

    @JsonProperty("customerNumber")
    public String getCustomerNumber() {
        return customerNumber;
    }

    @JsonProperty("customerNumber")
    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    @JsonProperty("companyNumber")
    public String getCompanyNumber() {
        return companyNumber;
    }

    @JsonProperty("companyNumber")
    public void setCompanyNumber(String companyNumber) {
        this.companyNumber = companyNumber;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(CustomerKey.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
                .append('[');
        sb.append("customerNumber");
        sb.append('=');
        sb.append(((this.customerNumber==null)?"<null>":this.customerNumber));
        sb.append(',');
        sb.append("companyNumber");
        sb.append('=');
        sb.append(((this.companyNumber==null)?"<Null>":this.companyNumber));
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
        result = ((result*31)+ ((this.customerNumber==null)?0:this.customerNumber.hashCode()));
        result = ((result*31)+ ((this.companyNumber == null)?0:this.companyNumber.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if(other == this) {
            return true;
        }
        if(other instanceof CustomerKey == false) {
            return false;
        }
        CustomerKey rhs = ((CustomerKey) other);
        return(((this.customerNumber==rhs.customerNumber)||((this.customerNumber!=null)&&this.customerNumber.equals(rhs.customerNumber)))
                &&((this.companyNumber == rhs.companyNumber)|| ((this.companyNumber!=null)&& this.companyNumber.equals(rhs.companyNumber))));
    }



}
