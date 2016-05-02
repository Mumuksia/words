package com.muksia.services;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;
import com.muksia.model.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author yurzav
 */
@RequestScoped
public class PersistenceService {
    
    //mongodb://<dbuser>:<dbpassword>@ds045511.mlab.com:45511/dictionary
    
    public List<Person> getAllPersons(){
        return new ArrayList<>();
    }

    public Optional<Person> gerPerson(final String name){
        return Optional.empty();
    }
    
    public void updatePerson(final Person p){
        getMongoClient().insertOne(p.createDocument());
    }
    
    private MongoCollection getMongoClient(){        
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://root:iverson@ds045511.mlab.com:45511/dictionary"));    
        MongoDatabase database = mongoClient.getDatabase("Dictionary");
        return database.getCollection("persons");
    }
    
           
}
