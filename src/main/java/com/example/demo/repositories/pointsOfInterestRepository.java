package com.example.demo.repositories;

import com.example.demo.pointsOfInterest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface pointsOfInterestRepository extends MongoRepository<pointsOfInterest, String>
{
    //adicionar métodos de consulta personalizada (se for necessário)
    //List<pointsOfInterest> findByDistance(int x, int y, int dmax);
    List<pointsOfInterest> findByName(String name);
}
