package com.github.daggerok.providers;

import org.slf4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import static java.util.Collections.singletonMap;
import static javax.ws.rs.core.HttpHeaders.ACCEPT;
import static javax.ws.rs.core.HttpHeaders.CONTENT_TYPE;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.BAD_REQUEST;

@Provider
public class ExceptionMapperProvider implements ExceptionMapper<Exception> {

  @Inject
  Logger log;

  @Override
  public Response toResponse(Exception exception) {
    final String error = exception.getLocalizedMessage();
    log.error("oops: {}", error, exception);
    return Response.status(BAD_REQUEST)
                   .header(ACCEPT, APPLICATION_JSON)
                   .header(CONTENT_TYPE, APPLICATION_JSON)
                   .entity(singletonMap("oops", error))
                   .build();
  }
}
