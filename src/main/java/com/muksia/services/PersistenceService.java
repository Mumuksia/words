package com.muksia.services;

import com.muksia.model.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author yurzav
 */
@RequestScoped
public class PersistenceService {
    
    public List<Person> getAllPersons(){
        return new ArrayList<>();
    }

    public Optional<Person> gerPerson(final String name){
        return Optional.empty();
    }
    
    public void updatePerson(final Person person){
        
    }
}
