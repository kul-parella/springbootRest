package com.example.utils;

import com.example.common.StatusMessage;
import com.example.common.SystemError;

import java.util.ArrayList;
import java.util.List;

public class GetAccountDetailsUtils {

    public static List<StatusMessage> createStatusMessageList(String codeMsg, String builder) {
        StatusMessage message = new StatusMessage();
        message.setType(StatusMessage.Type.ERROR);
        message.setCode(codeMsg);
        message.setMessage(builder);
        List<StatusMessage> messageList = new ArrayList<>();
        messageList.add(message);
        return messageList;
    }

    public static List<SystemError> processExceptionSystemErrors(String exMsg) {
        SystemError systemError =
                new SystemError("AcctDetails", "Exception", null, exMsg);
        List<SystemError> sysErrs = new ArrayList<>();
        sysErrs.add(systemError);
        return sysErrs;
    }

    public static String trimRemainingLines(String str) {
        int index = str.indexOf(Constants.NEW_LINE);
        if(index != -1) {
            return str.substring(0, index);
        }else {
            return str;
        }
    }
}
