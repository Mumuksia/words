package com.muksia.services;

import com.muksia.model.Person;
import com.muksia.model.Word;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author yurzav
 */
@RequestScoped
public class DictionaryService {

    @Inject
    PersistenceService persistenceService;
    
    @Inject
    PersonService personService;

    private final Random randomGenerator = new Random();

    public Optional<Word> getRandomWordForPerson(final String personName) {

        final List<Person> personList = persistenceService.getAllPersons();
        Optional<Person> person = personList.stream().filter(p -> personName.equals(p.getName())).findAny();
        if (person.isPresent()) {
            return getRandomWord(person);
        }

        return Optional.empty();
    }

    public void addWord(final String word, final String translation, final String personName) {
        persistenceService.updatePerson(new Person(personName, "something", Arrays.asList(new Word(word, translation, new Date()))));
    }

    public void setPersistenceService(PersistenceService persistenceService) {
        this.persistenceService = persistenceService;
    }
    
    
    private Optional<Word> getRandomWord(Optional<Person> person) {
        final List<Word> words = person.get().getWords();
        final int randomId = randomGenerator.nextInt(words.size());
        return Optional.of(words.get(randomId));
    }

}
