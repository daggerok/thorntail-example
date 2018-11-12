package com.github.daggerok.resources;

import org.slf4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.*;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("")
@Stateless
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class MyResource {

  @Inject
  Logger log;

  @GET
  public JsonObject get(JsonObject map) {
    return jsonObject(GET.class.getSimpleName(), map);
  }

  @POST
  public JsonObject post(JsonObject map) {
    return jsonObject(POST.class.getSimpleName(), map);
  }

  @GET
  public void getVoid() {
    log.info("{}: void", GET.class.getSimpleName());
  }

  @POST
  public void postVoid() {
    log.info("{}: void", POST.class.getSimpleName());
  }

  private JsonObject jsonObject(String operation, JsonObject jsonObject) {
    log.info("{}: {}", operation, jsonObject);
    return jsonObject;
  }
}
