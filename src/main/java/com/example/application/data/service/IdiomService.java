package com.example.application.data.service;

import com.example.application.data.entity.Idiom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Service
public class IdiomService {

    private List<Idiom> idiomList;

    public IdiomService(List<Idiom> idiomList) {
        this.idiomList = idiomList;
    }

    public List<Idiom> getIdioms() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8000/learn?kind=idiom";
        ResponseEntity<List<Idiom>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Idiom>>() {
        });
        return responseEntity.getBody();
    }


}
