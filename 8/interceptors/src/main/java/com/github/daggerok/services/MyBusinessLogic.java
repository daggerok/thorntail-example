package com.github.daggerok.services;

import org.slf4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.json.JsonObject;

import static java.util.Objects.isNull;

@Stateless
public class MyBusinessLogic {

  @Inject
  Logger log;

  @Interceptors(LoggingInterceptor.class)
  public String handle(JsonObject jsonObject) {
    log.info("handling business logic for: {}", jsonObject);
    if (isNull(jsonObject)) return "Fuk<.as[=fl+f@313fm_!";
    return "Hello, " + jsonObject.getString("name", "buddy") + "!";
  }
}
