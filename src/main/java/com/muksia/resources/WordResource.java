package com.muksia.resources;

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
    public String developer(){
        return "something to test";
    }
    
    @GET
    @Path("{first}-{last}")
    public String developer(@PathParam("first") String first, @PathParam("last") String last){
        return first + "  " + last;
    }
}
