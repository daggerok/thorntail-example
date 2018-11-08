package com.github.daggerok.resources;

import javax.ejb.Stateless;
import javax.json.Json;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("")
@Stateless
@Produces(APPLICATION_JSON)
public class MyResource {

  @GET
  public Response hello() {
    return Response.ok(Json.createObjectBuilder()
                           .add("message", "Hello, Thorntail!")
                           .build())
                   .build();
  }
}
