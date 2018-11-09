package com.github.daggerok.resources;

import com.github.daggerok.beans.*;
import org.slf4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import static java.util.Arrays.asList;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Stateless
@Path("{path: .*?}")
@Produces(APPLICATION_JSON)
public class MyResource {

  @Inject
  Logger log;

  @Inject
  DependentDefaultScopedCdiBean dependentDefaultScopedCdiBean;

  @Inject
  ApplicationScopedCdiBean applicationScopedCdiBean;

  @Inject
  SingletonApplicationScopedEjbBean singletonApplicationScopedEjbBean;

  @Inject
  StatelessScopedPulledEjbBean statelessScopedPulledEjbBean;

  @Inject
  StatefulHttpSessionScopedEjbBean statefulHttpSessionScopedEjbBean;

  @GET
  @Consumes(APPLICATION_JSON)
  public Response getDefaultScope() {
    log.info("default scope");
    return Response.ok(asList(
        // CDI:
        dependentDefaultScopedCdiBean.getDescription(),
        applicationScopedCdiBean.getDescription(),
        // EJB:
        singletonApplicationScopedEjbBean.getDescription(),
        statelessScopedPulledEjbBean.getDescription(),
        statefulHttpSessionScopedEjbBean.getDescription()
    )).build();
  }
}
