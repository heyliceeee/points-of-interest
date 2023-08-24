package com.example.demo.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.example.demo.repositories")
public class mongoDBConfig extends AbstractMongoClientConfiguration {
    // Configurações do Spring Data MongoDB (se necessário)

    @Override
    protected String getDatabaseName() {
        return "gps"; // Substitua pelo nome do seu banco de dados
    }

    @Override
    protected void configureClientSettings(MongoClientSettings.Builder builder) {
        builder.applyConnectionString(new ConnectionString("mongodb://localhost:27017")); // Substitua pela sua URI de conexão
    }
}
