package com.springboot.restclient.client;


import com.springboot.restclient.dto.Tutorial;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class TutorialServiceClient {

    private final RestClient restClient;

    public TutorialServiceClient() {
        restClient = RestClient.builder()
                .baseUrl("http://localhost:8081")
                .build();
    }

    public Tutorial saveNewProduct(Tutorial tutorial) {
        return restClient.post()
                .uri("/api/tutorials")
                .contentType(MediaType.APPLICATION_JSON)
                .body(tutorial)
                .retrieve()
                .body(Tutorial.class);
    }


    public List<Tutorial> getAllTutorials(){
        return restClient.get()
                .uri("/api/tutorials")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Tutorial>>(){});
    }

    public Tutorial getTutorial(String id){
        return restClient.get()
                .uri("/api/tutorials/{id}",id)
                .retrieve()
                .body(Tutorial.class);
    }


    public Tutorial updateTutorial(String id, Tutorial tutorial){
        return restClient.put()
                .uri("/api/tutorials/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .body(tutorial)
                .retrieve()
                .body(Tutorial.class);
    }

    public String deleteTutorial(String id){
        restClient.delete()
                .uri("/api/tutorials/{id}",id)
                .retrieve()
                .toBodilessEntity();
        return "tutorial removed : "+id;
    }


}

