package com.example.backend.repository;

import com.example.backend.models.ClientDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepository extends MongoRepository<ClientDocument, String> {}
