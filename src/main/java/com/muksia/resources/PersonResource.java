package com.muksia.resources;

import com.muksia.model.Person;
import com.muksia.services.DictionaryService;
import com.muksia.services.PersonService;
import java.util.Optional;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author yurzav
 */
@RequestScoped
@Path("person")
public class PersonResource {
    
    @Inject
    PersonService personService;
    
    @GET
    @Path("{person}")
    public Person getPerson(@PathParam("person") String person){
        Optional<Person> optPerson = personService.getPersonByName(person);
        if (optPerson.isPresent()){
            return optPerson.get();
        }
        return null;
    }

}
