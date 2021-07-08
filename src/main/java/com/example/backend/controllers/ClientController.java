package com.example.backend.controllers;

import ch.qos.logback.core.net.server.Client;
import com.example.backend.models.ClientDocument;
import com.example.backend.repository.ClientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientRepository repository;

    public ClientController(ClientRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public List<ClientDocument> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ClientDocument> getById(@PathVariable String id) {
        return repository.findById(id);
    }

    @PostMapping("")
    public ClientDocument insert(@RequestBody ClientDocument client) {
        return repository.insert(client);
    }

    @PutMapping("/{id}")
    public ClientDocument update(@PathVariable String id, @RequestBody ClientDocument client) {
        return repository.save(client);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody ResponseEntity<String> delete(@PathVariable String id) {
        repository.delete(new ClientDocument(id));
        return new ResponseEntity<String>("deleted", HttpStatus.OK);
    }
}
