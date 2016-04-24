package com.muksia.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author Muksia
 */
@Path("developers")
public class TestResource {
   
    @GET
    public String developer(){
        return "something to test";
    }
}
