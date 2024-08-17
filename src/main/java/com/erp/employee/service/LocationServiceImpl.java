package com.erp.employee.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LocationServiceImpl implements LocationService{
    @Override
    public String getLocation() {
        String url = "http://api.open-notify.org/iss-now.json";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }
}
