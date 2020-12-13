package com.example.controllers;

import com.example.entity.AccountInfo;
import com.example.entity.AccountKey;
import com.example.entity.CustomerKey;
import com.example.entity.GetAccountV1Request;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

public class GetAccountDetailsControllerHelperTest {


    public static GetAccountV1Request getRequest(){
        GetAccountV1Request req = new GetAccountV1Request();

        AccountKey actKey = new AccountKey();
        actKey.setAccountNumber("98765445678");
        actKey.setCompanyNumber("876");
        actKey.setProductCode("XCR");

        AccountInfo actInfo = new AccountInfo();
        actInfo.setAccountKey(actKey);

        List<AccountInfo> actInfoList = new ArrayList<>();
        actInfoList.add(actInfo);

        CustomerKey custKey = new CustomerKey();
        custKey.setCompanyNumber("123456");
        custKey.setCustomerNumber("12345");


        req.setAccountList(actInfoList);
        req.setCustomerKey(custKey);

        return  req;

    }

    public static HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("content-Type","application/json");
        return headers;
    }


    public static MockMvc getMockMvcBuilders(GetAccountDetailsV1Controller controller) {
        return MockMvcBuilders.standaloneSetup(controller).build();
    }

    public static String getAccountDetailsV1RequestJSON () {
        String requestJSON =

        "{\n" +
           " \"customerKey\": { \n" +
          " \"customerNumber\": \"10778987664\",\n"+
          " \"companyNumber\": \"999\" \n" +
          "},\n" +

          "\"accountList\": [{ \n" +
          "\"accountKey\": { \n"+
          "\"accountNumber\": \"989549309\", \n"+
          "\"productCode\": \"DDA\", \n"+
          "\"companyNumber\": \"114\" \n"+
          " },\n"+

          " \"debitCardAccountKey\": { \n"+
          " \"accountNumber\": \"39439493989\", \n"+
          "\"productCode\": \"PIA\", \n"+
          " \"companyNumber\": \"114\" \n"+
          "} } ] }";

        return requestJSON;

    }

}
