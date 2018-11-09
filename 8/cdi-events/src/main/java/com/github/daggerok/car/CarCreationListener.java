package com.github.daggerok.car;

import com.github.daggerok.events.CarCreatedEvent;
import org.slf4j.Logger;

import javax.enterprise.context.Dependent;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@Dependent
public class CarCreationListener {

  @Inject
  Logger log;

  @Inject
  Event<CarCreatedEvent> events;

  public void onCarCreatedEvent(@Observes CarCreatedEvent event) {
    log.info("new event: {}", event);
  }
}
