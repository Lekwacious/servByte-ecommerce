package com.ecommerce.servbyte.service;

import com.ecommerce.servbyte.data.payload.request.InitializeTransactionRequest;
import com.ecommerce.servbyte.data.payload.response.InitializeTransactionResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public interface InitializeTransactionService {
    InitializeTransactionResponse
    initializeTransaction (InitializeTransactionRequest initializeTransactionRequest);
}
