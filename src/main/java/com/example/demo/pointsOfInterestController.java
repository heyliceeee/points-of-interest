package com.example.demo;

import com.example.demo.repositories.pointsOfInterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/poi")
public class pointsOfInterestController
{
    private static pointsOfInterestRepository poiRepository;

    @Autowired
    public pointsOfInterestController(pointsOfInterestRepository poiRepository){
        this.poiRepository = poiRepository;
    }

    /*@GetMapping
    public static List<pointsOfInterest> getByDistance(@RequestParam int x, @RequestParam int y, @RequestParam int dmax) {
        return poiRepository.findByDistance(x, y, dmax);
    }*/

    @GetMapping
    public static List<pointsOfInterest> getAll(){
        return poiRepository.findAll();
    }

    @PostMapping
    public pointsOfInterest addPoi(@RequestBody pointsOfInterest poi){
        return poiRepository.save(poi);
    }
}
