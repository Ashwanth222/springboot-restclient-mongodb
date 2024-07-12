package com.springboot.restclient.controller;

import com.springboot.restclient.client.TutorialServiceClient;
import com.springboot.restclient.dto.Tutorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tutorial-client/tutorials")
public class TutorialClientController {

    @Autowired
    private TutorialServiceClient serviceClient;


    @PostMapping
    public Tutorial saveNewProduct(@RequestBody Tutorial tutorial) {
        return serviceClient.saveNewProduct(tutorial);
    }


    @GetMapping
    public List<Tutorial> getAllProducts(){
        return serviceClient.getAllTutorials();
    }

    @GetMapping("/{id}")
    public Tutorial getProduct(@PathVariable String id){
        return serviceClient.getTutorial(id);
    }


    @PutMapping("/{id}")
    public Tutorial updateProduct(@PathVariable String id,@RequestBody Tutorial tutorial){
        return serviceClient.updateTutorial(id, tutorial);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable String id){
        return serviceClient.deleteTutorial(id);
    }

}

