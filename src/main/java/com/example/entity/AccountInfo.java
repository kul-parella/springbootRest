package com.example.entity;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.validation.constraints.NotNull;
import javax.validation.Valid;

/**
 * AccountInfo entity class.
 * @author Kuladeep Parella.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
        "accountkey",
        "debitCardAccountKey"
})
public class AccountInfo {

    @JsonProperty("accountKey")
    @Valid
    @NotNull
    private AccountKey accountKey;

    @JsonProperty("debitCardAccountKey")
    @Valid
    private AccountKey debitCardAccountKey;

    public AccountInfo() {
    }

    public AccountInfo(@Valid @NotNull AccountKey accountKey, @Valid AccountKey debitCardAccountKey) {
        super();
        this.accountKey = accountKey;
        this.debitCardAccountKey = debitCardAccountKey;
    }

    @JsonProperty("accountKey")
    public AccountKey getAccountKey() {
        return accountKey;
    }

    @JsonProperty("accountKey")
    public void setAccountKey(AccountKey accountKey) {
        this.accountKey = accountKey;
    }

    @JsonProperty("debitCardAccountKey")
    public AccountKey getDebitCardAccountKey() {
        return debitCardAccountKey;
    }

    @JsonProperty("debitCardAccountKey")
    public void setDebitCardAccountKey(AccountKey debitCardAccountKey) {
        this.debitCardAccountKey = debitCardAccountKey;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(AccountInfo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
                .append('[');
        sb.append("accountKey");
        sb.append('=');
        sb.append(((this.accountKey==null)?"<null>":this.accountKey));
        sb.append(',');
        sb.append("debitCardAccountKey");
        sb.append('=');
        sb.append(((this.debitCardAccountKey==null)?"<Null>":this.debitCardAccountKey));
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
        result = ((result*31)+ ((this.accountKey==null)?0:this.accountKey.hashCode()));
        result = ((result*31)+ ((this.debitCardAccountKey == null)?0:this.debitCardAccountKey.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if(other == this) {
            return true;
        }
        if(other instanceof AccountInfo == false) {
            return false;
        }
        AccountInfo rhs = ((AccountInfo) other);
        return(((this.accountKey==rhs.accountKey)||((this.accountKey!=null)&&this.accountKey.equals(rhs.accountKey)))
                &&((this.debitCardAccountKey == rhs.debitCardAccountKey)|| ((this.debitCardAccountKey!=null)&& this.debitCardAccountKey.equals(rhs.debitCardAccountKey))));
    }
}
