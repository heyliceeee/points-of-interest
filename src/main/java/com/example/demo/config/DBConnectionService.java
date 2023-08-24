package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class DBConnectionService {
    private static MongoTemplate mongoTemplate = null;

    @Autowired
    public DBConnectionService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public static boolean checkDatabaseConnection() {
        try {
            // Tente acessar uma coleção (pode ser qualquer coleção existente em seu banco de dados)
            mongoTemplate.getCollection("pointsOfInterest").countDocuments();
            return true; // Se não ocorrer exceção, a conexão foi estabelecida com sucesso
        } catch (Exception e) {
            // Trate a exceção, se necessário
            return false; // Conexão não foi estabelecida
        }
    }
}
