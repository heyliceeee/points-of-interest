package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface pointsOfInterestRepository extends MongoRepository<pointsOfInterest, String>
{
    //adicionar métodos de consulta personalizada (se for necessário)
}
