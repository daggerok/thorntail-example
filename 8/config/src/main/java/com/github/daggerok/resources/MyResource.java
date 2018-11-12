package com.github.daggerok.resources;

import com.github.daggerok.config.Config;
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

  @Inject
  @Config("app.banner")
  String banner;

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
    jsonObject(GET.class.getSimpleName(), null);
  }

  @POST
  public void postVoid() {
    jsonObject(POST.class.getSimpleName(), null);
  }

  private JsonObject jsonObject(String operation, JsonObject jsonObject) {
    log.info("[{}] {}: {}", banner, operation, jsonObject);
    return jsonObject;
  }
}
