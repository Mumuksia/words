package com.muksia.services;

import com.muksia.model.Person;
import java.util.ArrayList;
import org.easymock.EasyMock;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author yurzav
 */
public class PersonServiceTest {

    PersistenceService persistenceService;
    PersonService personService;

    @BeforeClass
    public void init() {
        persistenceService = EasyMock.mock(PersistenceService.class);
        EasyMock.expect(persistenceService.getAllPersons()).andReturn(new ArrayList<>()).times(1);
        persistenceService.updatePerson(mockPerson());
        EasyMock.expectLastCall().once();
        EasyMock.replay(persistenceService);
        personService = new PersonService();
        personService.setPersistenceService(persistenceService);
    }
    
    @Test
    public void updatePersonTest(){
        persistenceService.updatePerson(mockPerson());
    }
    
    @Test
    public void getAllPersonsTest(){
        Assert.assertNotNull(persistenceService.getAllPersons());
    }

    private Person mockPerson() {
        return new Person("name", "comment", new ArrayList<>());
    }
}
