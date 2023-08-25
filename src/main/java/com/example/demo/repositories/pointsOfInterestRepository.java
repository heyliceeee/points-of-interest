package com.example.demo.repositories;

import com.example.demo.pointsOfInterest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface pointsOfInterestRepository extends MongoRepository<pointsOfInterest, String>
{
    @Query("{ $and: [ { 'x': { $gte: ?0, $lte: ?2 } }, { 'y': { $gte: ?1, $lte: ?3 } } ] }")
    List<pointsOfInterest> findByDistance(double x, double y, double dxmax, double dymax);
    //List<pointsOfInterest> findByName(String name);
}
