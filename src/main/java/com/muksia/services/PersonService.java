package com.muksia.services;

import com.muksia.model.Person;
import java.util.ArrayList;
import java.util.Optional;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author yurzav
 */
@RequestScoped
public class PersonService {
    
    @Inject
    PersistenceService persistenceService;
    
    public Optional<Person> getPersonByName(final String name){
        return persistenceService.gerPerson(name);
    }
    
    public void addNewPerson(final String name, final String comment){
        persistenceService.updatePerson(new Person(name, comment, new ArrayList<>()));
    }

    public void setPersistenceService(PersistenceService persistenceService) {
        this.persistenceService = persistenceService;
    }

}
