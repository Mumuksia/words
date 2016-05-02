package com.muksia.services;

import com.muksia.model.Person;
import com.muksia.model.Word;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.easymock.EasyMock;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author yurzav
 */
public class DictionaryServiceTest {
    
    private DictionaryService dictionaryService;
    private PersistenceService persistenceService;
    private static final String PERSON = "PERSON_TO_TEST";

    @BeforeClass
    public void init(){
        persistenceService = EasyMock.mock(PersistenceService.class);        
        EasyMock.expect(persistenceService.getAllPersons()).andReturn(mockPersons()).times(2);
        EasyMock.replay(persistenceService);
        dictionaryService = new DictionaryService();        
        dictionaryService.setPersistenceService(persistenceService);
    }
    
    @Test
    public void getRandomWordForUserTest_PersonNotExist() {        
        final Optional<Word> word = dictionaryService.getRandomWordForPerson("some");        
        Assert.assertFalse(word.isPresent());
    }
    
    @Test
    public void getRandomWordForUserTest_PersonExist() {        
        final Optional<Word> word = dictionaryService.getRandomWordForPerson(PERSON);        
        Assert.assertTrue(word.isPresent());
    }

    private List<Person> mockPersons() {
        final List<Person> persons = new ArrayList<>();
        final Word word1 = new Word(PERSON, PERSON, new Date());
        final Word word2 = new Word(PERSON + "1", PERSON + "t1", new Date());
        final Word word3 = new Word(PERSON + "2", PERSON + "t2", new Date());
        final List<Word> words = new ArrayList<>();
        words.add(word1);
        words.add(word2);
        words.add(word3);
        final Person p = new Person(PERSON, "comment", words);
        
        persons.add(p);
        return persons;
    }

}
