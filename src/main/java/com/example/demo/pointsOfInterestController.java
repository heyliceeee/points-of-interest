package com.example.demo;

import com.example.demo.repositories.pointsOfInterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @GetMapping("/distance")
    public static List<pointsOfInterest> getByDistance(@RequestParam double x, @RequestParam double y, @RequestParam double dmax) {
        List<String> listIDs = new ArrayList<>();

        //verificar a poi
        for(int i=0; i < poiRepository.findAll().size(); i++){

            double poiX = poiRepository.findAll().get(i).getX();
            double poiY = poiRepository.findAll().get(i).getY();

            double distance = Math.sqrt(Math.pow((poiX - x), 2) + Math.pow((poiY - y), 2));

            if(distance <= dmax){ //se o poi esta na area
                String poiID = poiRepository.findAll().get(i).getId();
                listIDs.add(poiID);
            }
        }

        if(listIDs.isEmpty()){

            listIDs.add("Vazio");
        }

        return poiRepository.findAllById(listIDs);
    }

    @GetMapping("/all")
    public static List<pointsOfInterest> getAll(){
        return poiRepository.findAll();
    }

    @PostMapping("/create")
    public pointsOfInterest addPoi(@RequestBody pointsOfInterest poi){
        return poiRepository.save(poi);
    }
}
