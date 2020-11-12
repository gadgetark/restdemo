package com.kc.restdemo.service.impl;

import com.kc.restdemo.dto.UserAccountSource;
import com.kc.restdemo.service.UserLookupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserLookupServiceImpl implements UserLookupService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final RestTemplate restTemplate;
    private String apiHostUrl;

    public UserLookupServiceImpl(RestTemplate restTemplate,  @Value("${api.host.url}") String apiHostUrl) {
        this.restTemplate = restTemplate;
        this.apiHostUrl = apiHostUrl;
    }

    @Override
    public UserAccountSource getUserAccountInfo(String username) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<UserAccountSource> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<UserAccountSource> response;
        try {
            response = restTemplate.exchange(apiHostUrl + "/users/" + username, HttpMethod.GET, httpEntity, UserAccountSource.class);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
        return response.getBody();
    }

}
