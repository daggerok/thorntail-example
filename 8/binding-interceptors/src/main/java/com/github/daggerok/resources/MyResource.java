package com.github.daggerok.resources;

import com.github.daggerok.services.MyBusinessLogic;

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
  @Path("active")
  @Consumes(APPLICATION_JSON)
  public Response active(JsonObject jsonObject) {
    return Response.ok().entity(Json.createObjectBuilder()
                                    .add("message", logic.handleActive(jsonObject))
                                    .build())
                   .build();
  }

  @POST
  @Path("inactive")
  @Consumes(APPLICATION_JSON)
  public Response inactive(JsonObject jsonObject) {
    return Response.ok().entity(Json.createObjectBuilder()
                                    .add("message", logic.handleInactive(jsonObject))
                                    .build())
                   .build();
  }
}
