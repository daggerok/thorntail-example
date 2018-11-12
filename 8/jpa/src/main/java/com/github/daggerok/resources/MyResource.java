package com.github.daggerok.resources;

import com.github.daggerok.entities.AggregateRoot;
import org.slf4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.github.daggerok.entities.AggregateRoot.FIND_ALL;
import static com.github.daggerok.entities.AggregateRoot.FIND_BY_ID;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;

@Path("")
@Stateless
@Produces(APPLICATION_JSON)
public class MyResource {

  @Inject
  Logger log;

  @Inject
  EntityManager em;

  @Context
  UriInfo uriInfo;

  @GET
  public Response getAll() {
    final List<AggregateRoot> entities = em.createNamedQuery(FIND_ALL, AggregateRoot.class)
                                           .getResultList();
    log.info("found: {}", entities);
    return Response.ok(entities).build();
  }

  @GET
  @Path("{id}")
  public Response getOne(@PathParam("id") UUID id) {
    final Optional<AggregateRoot> result = em.createNamedQuery(FIND_BY_ID, AggregateRoot.class)
                                             .setParameter("id", id)
                                             .getResultList()
                                             .stream()
                                             .findFirst();
    return result.map(Response::ok)
                 .orElseGet(() -> Response.status(NOT_FOUND))
                 .build();
  }

  @POST
  @Consumes(APPLICATION_JSON)
  public Response add(JsonObject jsonObject) {
    final String json = jsonObject.toString();
    final AggregateRoot aggregateRoot = AggregateRoot.of(json);
    log.info("store: {}", json);
    em.persist(aggregateRoot);
    return Response.created(uriInfo.getBaseUriBuilder()
                                   .path(MyResource.class)
                                   .path(MyResource.class, "getOne")
                                   .build(aggregateRoot.getId()))
                   .build();
  }
}
