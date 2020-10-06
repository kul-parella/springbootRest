package com.example.common;

import com.fasterxml.jackson.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
        "creatorApplicationId",
        "code",
        "subCode",
        "message"
})
public class SystemError {

    @JsonProperty("creatorApplicationId")
    private String creatorApplicationId;

    @JsonProperty("code")
    private String code;

    @JsonProperty("subCode")
    private String subCode;

    @JsonProperty("message")
    private String message;

    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<>();

    public SystemError() {
    }

    public SystemError(String creatorApplicationId, String code, String subCode, String message) {
        super();
        this.creatorApplicationId = creatorApplicationId;
        this.code = code;
        this.subCode = subCode;
        this.message = message;
    }

    @JsonProperty("creatorApplicationId")
    public String getCreatorApplicationId() {
        return creatorApplicationId;
    }

    @JsonProperty("creatorApplicationId")
    public void setCreatorApplicationId(String creatorApplicationId) {
        this.creatorApplicationId = creatorApplicationId;
    }

    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    @JsonProperty("subCode")
    public String getSubCode() {
        return subCode;
    }

    @JsonProperty("subCode")
    public void setSubCode(String subCode) {
        this.subCode = subCode;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
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
        sb.append(SystemError.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
                .append('[');
        sb.append("creatorApplicationId");
        sb.append('=');
        sb.append(((this.creatorApplicationId==null)?"<null>":this.creatorApplicationId));
        sb.append(',');
        sb.append("code");
        sb.append('=');
        sb.append(((this.code==null)?"<null>":this.code));
        sb.append(',');
        sb.append("subCode");
        sb.append('=');
        sb.append(((this.subCode==null)?"<Null>":this.subCode));
        sb.append(',');
        sb.append("message");
        sb.append('=');
        sb.append(((this.message==null)?"<Null>":this.message));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties==null)?"<Null>":this.additionalProperties));
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
        result = ((result*31)+ ((this.additionalProperties==null)?0:this.additionalProperties.hashCode()));
        result = ((result*31)+ ((this.code==null)?0:this.code.hashCode()));
        result = ((result*31)+ ((this.subCode == null)?0:this.subCode.hashCode()));
        result = ((result*31)+ ((this.message==null)?0:this.message.hashCode()));
        result = ((result*31)+ ((this.additionalProperties==null)?0:this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if(other == this) {
            return true;
        }
        if(other instanceof SystemError == false) {
            return false;
        }
        SystemError rhs = ((SystemError) other);
        return(((this.code==rhs.code)||((this.code!=null)&&this.code.equals(rhs.code)))
                &&((this.subCode == rhs.subCode)|| ((this.subCode!=null)&& this.subCode.equals(rhs.subCode)))
                &&((this.creatorApplicationId == rhs.creatorApplicationId)|| ((this.creatorApplicationId!=null)
                && this.creatorApplicationId.equals(rhs.creatorApplicationId)))
                &&((this.message == rhs.message)|| ((this.message!=null)&& this.message.equals(rhs.message)))
                &&((this.additionalProperties == rhs.additionalProperties)|| ((this.additionalProperties!=null)
                && this.additionalProperties.equals(rhs.additionalProperties)))
        );
    }

}
