package com.example.application.data.service;

import com.example.application.data.entity.Phrasal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Service
public class PhrasalService {


    private List<Phrasal> phrasalList;

    public PhrasalService(List<Phrasal> phrasalList) {
        this.phrasalList = phrasalList;
    }

    public List<Phrasal> getPhrasals() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8000/learn?kind=phrasal";
        ResponseEntity<List<Phrasal>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Phrasal>>() {
        });
        return responseEntity.getBody();
    }


}
