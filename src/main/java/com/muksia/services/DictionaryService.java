package com.muksia.services;

import com.muksia.model.Person;
import com.muksia.model.Word;
import java.util.Random;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * @author yurzav
 */
@RequestScoped
public class DictionaryService {
    
    @Inject
    PersistenceService persistenceService;
    
    private Random randomGenerator = new Random();
    
    public Optional<Word> getRandomWordForPerson(final String personName){
        
        final List<Person> personList = persistenceService.getAllPersons();
        Optional<Person> person = personList.stream().filter(p->personName.equals(p.getName())).findAny();
        if (person.isPresent()){
            final List<Word> words = person.get().getWords();
            final int randomId = randomGenerator.nextInt(words.size());
        
        return Optional.of(words.get(randomId));
        }
        
        return Optional.empty();        
    }
    
    public void addWord(final String word, final String translation){
        persistenceService.updatePerson(new Person(word, "something"));
    }

    public void setPersistenceService(PersistenceService persistenceService) {
        this.persistenceService = persistenceService;
    }

}
