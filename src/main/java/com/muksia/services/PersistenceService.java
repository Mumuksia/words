package com.muksia.services;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.muksia.model.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author yurzav
 */
@RequestScoped
public class PersistenceService {
    
    @Inject
    private ConnectorService connectorService;
    
    public List<Person> getAllPersons(){
        return new ArrayList<>();
    }

    public Optional<Person> gerPerson(final String name){
        return Optional.empty();
    }
    
    public void updatePerson(final Person p){
        connectorService.getMongoClient().insertOne(p.createDocument());
    }
}
