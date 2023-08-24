package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/poi")
public class pointsOfInterestController
{
    @Autowired
    private pointsOfInterestRepository pointsOfInterestRepository;

    @GetMapping
    public List<pointsOfInterest> getAllPoi(){
        return pointsOfInterestRepository.findAll();
    }

    @PostMapping
    public pointsOfInterest addPoi(@RequestBody pointsOfInterest poi){
        return pointsOfInterestRepository.save(poi);
    }
}
