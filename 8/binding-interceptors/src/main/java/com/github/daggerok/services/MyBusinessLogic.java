package com.github.daggerok.services;

import org.slf4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.JsonObject;

import static java.util.Objects.isNull;

@Stateless
public class MyBusinessLogic {

  @Inject
  Logger log;

  @Track(TrackingType.ACTIVE)
  public String handleActive(JsonObject jsonObject) {
    log.info("handling business logic for: {}", jsonObject);
    if (isNull(jsonObject)) return "Fuk<.as[=fl+f@313fm_!";
    return "Hello, " + jsonObject.getString("name", "buddy") + "!";
  }

  @Track(TrackingType.INACTIVE)
  public String handleInactive(JsonObject jsonObject) {
    log.info("handling business logic for: {}", jsonObject);
    if (isNull(jsonObject)) return "Fuk<.as[=fl+f@313fm_!";
    return "Good bye, " + jsonObject.getString("name", "buddy") + "...";
  }
}
