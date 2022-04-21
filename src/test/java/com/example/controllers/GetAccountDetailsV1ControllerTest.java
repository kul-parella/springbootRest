package com.example.controllers;

import com.example.entity.*;
import com.example.services.GetAccountDetailsV1Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SuppressWarnings("unchecked")
public class GetAccountDetailsV1ControllerTest {

    private GetAccountDetailsV1Service service;
    private GetAccountDetailsV1Controller controller;

    @BeforeEach
    public void setUp() throws Exception {
        service = mock(GetAccountDetailsV1Service.class);
        controller = new GetAccountDetailsV1Controller(service);
    }

    @Test
    public void successTest() throws Exception {
        when(service.getAccountDetails(any(GetAccountV1Request.class)))
                .thenReturn(new ResponseEntity(new GetAccountDetailsV1Response(), HttpStatus.OK));
        ResponseEntity responseEntity = controller.getAccountDetails(GetAccountDetailsControllerHelperTest.getRequest(),
                GetAccountDetailsControllerHelperTest.getHeaders() );
        assertNotNull(responseEntity.getBody());
        assertNotNull(responseEntity.getHeaders());
    }

    @Test
    public void whenControllerCalledThenValidatePostMappingCorrect() throws Exception {
        GetAccountDetailsControllerHelperTest.getMockMvcBuilders(controller).perform(
                post("/api/getAccountDetails")
                .contentType("application/json")
                .content(GetAccountDetailsControllerHelperTest.getAccountDetailsV1RequestJSON())
        ).andExpect(status().isOk())
                .andReturn();
    }


    @Test
    public void whencontrollerCalledThenValidateRunTimeException() throws Exception {
        when(this.service.getAccountDetails(GetAccountDetailsControllerHelperTest.getRequest()))
                .thenThrow(new RuntimeException("RunTimeException Occurred"));
        try {
            this.controller.getAccountDetails(GetAccountDetailsControllerHelperTest.getRequest(),
                    GetAccountDetailsControllerHelperTest.getHeaders());
        }catch (RuntimeException ex) {
            assertEquals("RunTimeException Occurred", ex.getMessage());
        }
    }



}
