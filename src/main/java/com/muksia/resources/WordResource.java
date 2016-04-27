package com.muksia.resources;

import com.muksia.model.Person;
import com.muksia.services.DictionaryService;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author Muksia
 */
@RequestScoped
@Path("developers")
public class WordResource {
    
    @Inject
    DictionaryService dictionaryService;
   
    @GET
    public JsonObject developer(){
        dictionaryService.addWord("test", "ttttttrrrraaaa");
        return Json.createObjectBuilder().add(dictionaryService.getRandomWordForPerson("test"), 2).build();
    }
    
    @GET
    @Path("{first}-{last}")
    public Person developer(@PathParam("first") String first, @PathParam("last") String last){
        return new Person(first,last);
    }
}
