package com.muksia.resources;

import com.muksia.model.Person;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author Muksia
 */
@Path("developers")
public class WordResource {
   
    @GET
    public JsonObject developer(){
        return Json.createObjectBuilder().add("test", 2).build();
    }
    
    @GET
    @Path("{first}-{last}")
    public Person developer(@PathParam("first") String first, @PathParam("last") String last){
        return new Person(first,last);
    }
}
