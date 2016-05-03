package com.muksia.resources;

import com.muksia.model.Person;
import com.muksia.services.DictionaryService;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author Muksia
 */
@RequestScoped
@Path("words")
public class WordResource {
    
    @Inject
    DictionaryService dictionaryService;
   
    @GET
    public JsonObject developer(){
        dictionaryService.addWord("test", "ttttttrrrraaaa", "test");
        return Json.createObjectBuilder().add(dictionaryService.getRandomWordForPerson("test").get().getValue(),  2).build();
    }
    
    @POST
    @Path("{word}-{translation}-{person}")
    public JsonObject addWord(@PathParam("word") String word, @PathParam("translation") String translation, @PathParam("person") String person){
        dictionaryService.addWord(word, translation, person);
        return Json.createObjectBuilder().add(dictionaryService.getRandomWordForPerson(person).get().getValue(),  2).build();
    }

}
