package com.ecommerce.servbyte.service;

import com.ecommerce.servbyte.data.payload.request.InitializeTransactionRequest;
import com.ecommerce.servbyte.data.payload.response.InitializeTransactionResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class InitializeTransactionServiceImpl implements InitializeTransactionService {
    RestTemplate restTemplate = new RestTemplate();
    @Override
    public InitializeTransactionResponse initializeTransaction(InitializeTransactionRequest initializeTransactionRequest){
        String url = "https://api.paystack.co/transaction/initialize";
        HttpHeaders headers = new HttpHeaders();
        String key = "sk_test_b2ffbedf2d7b2cf1022923 5415ba2dac551c684e";
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + key);
        HttpEntity<InitializeTransactionRequest> entity = new HttpEntity<InitializeTransactionRequest>(initializeTransactionRequest,
                headers);
        ResponseEntity<InitializeTransactionResponse> response = restTemplate.postForEntity(url, entity,
                                InitializeTransactionResponse.class);
        return response.getBody();
    }
}
