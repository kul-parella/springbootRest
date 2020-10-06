package com.example.common;


import com.example.entity.CustomerKey;
import com.fasterxml.jackson.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
        "code",
        "subCode",
        "type",
        "message"
})
public class StatusMessage {

    @JsonProperty("code")
    @JsonPropertyDescription("Code")
  private String code;

    @JsonProperty("subCode")
    @JsonPropertyDescription("subCode")
  private String subCode;

    @JsonProperty("type")
    @JsonPropertyDescription("Type")
  private  StatusMessage.Type type;

    @JsonProperty("message")
    @JsonPropertyDescription("Message")
  private String message;

    @JsonIgnore
    @Valid
  private Map<String, Object> additionalProperties = new HashMap<>();

    public StatusMessage() {
    }

    public StatusMessage(String code, String subCode, Type type, String message) {
        this.code = code;
        this.subCode = subCode;
        this.type = type;
        this.message = message;
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

    @JsonProperty("type")
    public Type getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(Type type) {
        this.type = type;
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
        sb.append(StatusMessage.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
                .append('[');
        sb.append("code");
        sb.append('=');
        sb.append(((this.code==null)?"<null>":this.code));
        sb.append(',');
        sb.append("subCode");
        sb.append('=');
        sb.append(((this.subCode==null)?"<Null>":this.subCode));
        sb.append(',');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type==null)?"<Null>":this.type));
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
        result = ((result*31)+ ((this.code==null)?0:this.code.hashCode()));
        result = ((result*31)+ ((this.subCode == null)?0:this.subCode.hashCode()));
        result = ((result*31)+ ((this.type==null)?0:this.type.hashCode()));
        result = ((result*31)+ ((this.message==null)?0:this.message.hashCode()));
        result = ((result*31)+ ((this.additionalProperties==null)?0:this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if(other == this) {
            return true;
        }
        if(other instanceof StatusMessage == false) {
            return false;
        }
        StatusMessage rhs = ((StatusMessage) other);
        return(((this.code==rhs.code)||((this.code!=null)&&this.code.equals(rhs.code)))
                &&((this.subCode == rhs.subCode)|| ((this.subCode!=null)&& this.subCode.equals(rhs.subCode)))
                &&((this.type == rhs.type)|| ((this.type!=null)&& this.type.equals(rhs.type)))
                &&((this.message == rhs.message)|| ((this.message!=null)&& this.message.equals(rhs.message)))
                &&((this.additionalProperties == rhs.additionalProperties)|| ((this.additionalProperties!=null)&& this.additionalProperties.equals(rhs.additionalProperties)))
        );
    }




    public enum Type {

     INFORMATION("INFORMATION"),
     WARNING("WARNING"),
     ERROR("ERROR");

     private final String value;
     private final static Map<String, StatusMessage.Type> CONSTANTS = new HashMap<>();

     static {
         for(StatusMessage.Type c: values()){
             CONSTANTS.put(c.value, c);
         }
     }

     private Type(String value) {
          this.value=value;
     }

     @Override
     public String toString() {
         return this.value;
     }

     @JsonProperty
     public String value() { return this.value;}

     @JsonCreator
     public static StatusMessage.Type fromValue(String value) {
         StatusMessage.Type constant = CONSTANTS.get(value);
         if(constant==null){
             throw new IllegalArgumentException(value);
         } else {
             return constant;
         }
     }

 }


}
