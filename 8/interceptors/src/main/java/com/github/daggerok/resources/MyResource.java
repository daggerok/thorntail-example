package com.github.daggerok.resources;

import com.github.daggerok.services.MyBusinessLogic;
import org.slf4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("")
@Stateless
@Produces(APPLICATION_JSON)
public class MyResource {

  @Inject
  MyBusinessLogic logic;

  @POST
  @Consumes(APPLICATION_JSON)
  public Response add(JsonObject jsonObject) {
    return Response.ok().entity(Json.createObjectBuilder()
                                    .add("message", logic.handle(jsonObject))
                                    .build())
                   .build();
  }
}
