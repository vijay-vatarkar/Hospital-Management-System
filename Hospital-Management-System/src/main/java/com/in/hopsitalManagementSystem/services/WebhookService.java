package com.in.hopsitalManagementSystem.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class WebhookService {
    public final RestTemplate restTemplate;

    public WebhookService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public void sendWebhook(String url, Map<String, Object> payload){
        restTemplate.postForObject(url, payload, String.class);
    }
}
