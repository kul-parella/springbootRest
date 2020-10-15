package com.example.entity;

import com.example.common.StatusMessage;
import com.example.common.SystemError;
import com.fasterxml.jackson.annotation.*;

import javax.validation.Valid;
import java.util.*;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
        "accountDetailsList",
        "systemErrors",
        "statusMessages"
})
public class GetAccountDetailsV1Response {

    @JsonProperty("accountDetailsList")
    @JsonPropertyDescription("Account Details List.")
    @Valid
    private List<AccountDetails> accountDetailsList = new ArrayList<>();

    @JsonProperty("systemErrors")
    @Valid
    private List<SystemError> systemErrors = new ArrayList<>();

    @JsonProperty("statusMessages")
    @Valid
    private List<StatusMessage> statusMessages = new ArrayList<>();

    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<>();

    public GetAccountDetailsV1Response() {
    }

    public GetAccountDetailsV1Response(@Valid List<AccountDetails> accountDetailsList,
                                       @Valid List<SystemError> systemErrors,
                                       @Valid List<StatusMessage> statusMessages,
                                       @Valid Map<String, Object> additionalProperties) {
        this.accountDetailsList = accountDetailsList;
        this.systemErrors = systemErrors;
        this.statusMessages = statusMessages;
        this.additionalProperties = additionalProperties;
    }


    @JsonProperty("accountDetailsList")
    public List<AccountDetails> getAccountDetailsList() {
        return accountDetailsList;
    }


    @JsonProperty("accountDetailsList")
    public void setAccountDetailsList(List<AccountDetails> accountDetailsList) {
        this.accountDetailsList = accountDetailsList;
    }

    @JsonProperty("systemErrors")
    public List<SystemError> getSystemErrors() {
        return systemErrors;
    }

    @JsonProperty("systemErrors")
    public void setSystemErrors(List<SystemError> systemErrors) {
        this.systemErrors = systemErrors;
    }

    @JsonProperty("statusMessages")
    public List<StatusMessage> getStatusMessages() {
        return statusMessages;
    }

    @JsonProperty("statusMessages")
    public void setStatusMessages(List<StatusMessage> statusMessages) {
        this.statusMessages = statusMessages;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(GetAccountDetailsV1Response.class.getName()).append('@')
                .append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("accountDetailsList");
        sb.append('=');
        sb.append(((this.accountDetailsList==null)?"<null>":this.accountDetailsList));
        sb.append(',');
        sb.append("systemErrors");
        sb.append('=');
        sb.append(((this.systemErrors==null)?"<null>":this.systemErrors));
        sb.append(',');
        sb.append("statusMessages");
        sb.append('=');
        sb.append(((this.statusMessages==null)?"<null>":this.statusMessages));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties==null)?"<null>":this.additionalProperties));
        sb.append(',');
        if(sb.charAt((sb.length()-1))== ',') {
            sb.setCharAt((sb.length()-1), ']');
        }else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object other) {
        if(other == this) {
            return true;
        }
        if((other instanceof GetAccountDetailsV1Response)== false) {
            return false;
        }
        GetAccountDetailsV1Response rhs = ((GetAccountDetailsV1Response) other);
        return (((((this.accountDetailsList==rhs.accountDetailsList)||((this.accountDetailsList!=null)&&this.accountDetailsList.equals(rhs.accountDetailsList)))&&
                ((this.statusMessages==rhs.statusMessages)||((this.statusMessages!=null)&&this.statusMessages.equals(rhs.statusMessages))))&&
                ((this.additionalProperties==rhs.additionalProperties)||((this.additionalProperties!=null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&
                ((this.systemErrors==rhs.systemErrors)||((this.systemErrors!=null)&&this.systemErrors.equals(rhs.systemErrors))));
    }

    @Override
    public int hashCode() {
        int result =1 ;
        result = ((result*31)+((this.accountDetailsList==null)?0:this.accountDetailsList.hashCode()));
        result = ((result*31)+((this.statusMessages==null)?0:this.statusMessages.hashCode()));
        result = ((result*31)+((this.additionalProperties==null)?0:this.additionalProperties.hashCode()));
        result = ((result*31)+((this.systemErrors==null)?0:this.systemErrors.hashCode()));
        return result;
    }
}
