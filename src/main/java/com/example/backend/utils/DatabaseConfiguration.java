package com.example.backend.utils;

import com.example.backend.models.ClientDocument;
import com.example.backend.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

public class DatabaseConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(ClientRepository userRepository) {
        return strings -> {
            userRepository.insert(new ClientDocument("Peter", "Development"));
            userRepository.insert(new ClientDocument("Sam", "Operations"));
        };
    }
}
