package com.example.backend.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.Assert;

import java.util.Optional;

@Getter
@Setter
@Document(collection = "clients")
public class ClientDocument {

    @Id
    protected String id;
    private String firstname;
    private String lastname;

    public ClientDocument(String id) {
        this.id = id;
    }

    @PersistenceConstructor
    public ClientDocument(String firstname, String lastname) {
        Assert.notNull(firstname, "The given first name must not be null!");
        Assert.notNull(lastname, "The given last name must not be null!");

        this.firstname = firstname;
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return System.out.printf("%s, %s, %s", this.getId(), this.firstname, this.lastname).toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (this.id == null || obj == null || !(this.getClass().equals(obj.getClass()))) {
            return false;
        }
        ClientDocument that = (ClientDocument) obj;
        return this.id.equals(that.getId());
    }

    @Override
    public int hashCode() {
        return id == null ? 0 : id.hashCode();
    }
}
