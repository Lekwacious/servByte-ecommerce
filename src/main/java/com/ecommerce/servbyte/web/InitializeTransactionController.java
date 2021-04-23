package com.ecommerce.servbyte.web;

import com.ecommerce.servbyte.data.payload.request.InitializeTransactionRequest;
import com.ecommerce.servbyte.data.payload.response.InitializeTransactionResponse;
import com.ecommerce.servbyte.service.InitializeTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class InitializeTransactionController {

    @Autowired
    private InitializeTransactionService initializeTransactionService;
    @RequestMapping(
            path = "/initializetransaction",
            method = RequestMethod.POST)
    public InitializeTransactionResponse initializeTransaction(@RequestBody InitializeTransactionRequest
                    initializeTransactionRequest) {
        InitializeTransactionResponse initializeTransaction = initializeTransactionService.initializeTransaction(initializeTransactionRequest);
        return initializeTransaction; }
}
