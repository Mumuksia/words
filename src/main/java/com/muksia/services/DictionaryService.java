package com.muksia.services;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author yurzav
 */
@RequestScoped
public class DictionaryService {
    
    @Inject
    PersistenceService persistenceService;
    
    public String getRandomWordForPerson(final String person){
        persistenceService.getAllPersons();
        return "AbrA";
    }
    
    public void addWord(final String word, final String translation){
        
    }

}
